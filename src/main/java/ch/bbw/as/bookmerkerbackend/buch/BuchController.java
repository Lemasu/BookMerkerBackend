package ch.bbw.as.bookmerkerbackend.buch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BuchController {
	@Autowired
	private BuchRepository buchRepository;

	public BuchController(BuchRepository buchRepository) {
		this.buchRepository = buchRepository;
	}

	@GetMapping
	public List<Buch> getAllBooks() {
		return buchRepository.findAll();
	}

	@GetMapping("/{id}")
	public Buch getBuchById(@PathVariable Long id) {
		return buchRepository.findById(id).orElseThrow(() -> new BuchNotFoundException(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Buch addBook(@RequestBody Buch newBuch) {
		return buchRepository.save(newBuch);
	}

	@PutMapping("/{id}")
	public Buch updateBook(@RequestBody Buch newBuch, @PathVariable Long id) {
		return buchRepository.findById(id).map(buch -> {
			buch.setUrl_thumbnail(newBuch.getUrl_thumbnail());
			buch.setUrl_bild(newBuch.getUrl_bild());
			buch.setBuchtitel(newBuch.getBuchtitel());
			buch.setBeschreibung(newBuch.getBeschreibung());
			buch.setSeitenzahl(newBuch.getSeitenzahl());
			buch.setIsbn(newBuch.getIsbn());
			return buchRepository.save(buch);
		}).orElseGet(() -> {
			newBuch.setId(id);
			return buchRepository.save(newBuch);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		buchRepository.deleteById(id);
	}
}
