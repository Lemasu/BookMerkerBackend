package ch.bbw.as.bookmerkerbackend.buch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Das ist der Controller fuer die Buecher.
 * 
 * @author Alex Schaub
 * @version 1.0
 */
@RestController
@RequestMapping("/books")
public class BuchController {
	/**
	 * Das ist das Repository fuer die Buecher.
	 */
	@Autowired
	private BuchRepository buchRepository;

	public BuchController(BuchRepository buchRepository) {
		this.buchRepository = buchRepository;
	}

	/**
	 * Mit dieser Methode koennen alle Buecher geholt werden.
	 * 
	 * @return Es werden alle auf der Datenbank gespeicherte Buecher zurueckgegeben.
	 */
	@GetMapping
	public List<Buch> getAllBooks() {
		return buchRepository.findAll();
	}

	/**
	 * Mit dieser Methode kann ein einzelnes Buch geholt werden.
	 * 
	 * @param id Das ist die Id des Buches, welcher geholt werden soll.
	 * @return Es wird ein Buch mit der gewuenschten Id zurueckgegeben.
	 */
	@GetMapping("/{id}")
	public Buch getBuchById(@PathVariable Long id) {
		return buchRepository.findById(id).orElseThrow(() -> new BuchNotFoundException(id));
	}

	/**
	 * Mit dieser Methode kann ein einzelnes Buch erfasst werden.
	 * 
	 * @param newBuch Das ist das Buch, welches hinzugefuegt werden soll.
	 * @return Das neue Buch wird zurueckgegeben.
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Buch addBook(@RequestBody Buch newBuch) {
		return buchRepository.save(newBuch);
	}

	/**
	 * Mit dieser Methode kann ein einzelnes Buch verändert werden.
	 * Falls es kein Buch mit der gewuenschten Id gibt, wird ein Buch mit dieser Id erfasst.
	 * 
	 * @param newBuch Das sind die veraenderte Daten.
	 * @param id Das ist die Id des Buches, welches veraendert werden soll.
	 * @return Das veraenderte Buch wird zurueckgegeben.
	 */
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
	
	/**
	 * Mit dieser Methode kann man ein einzelnes Buch loeschen.
	 * 
	 * @param id Das ist die Id des Buches, welches geloescht werden soll.
	 */
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		buchRepository.deleteById(id);
	}
}
