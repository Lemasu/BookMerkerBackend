package ch.bbw.as.bookmerkerbackend.buch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return buchRepository.findById(id)
				.orElseThrow(() -> new BuchNotFoundException(id));
	}
}
