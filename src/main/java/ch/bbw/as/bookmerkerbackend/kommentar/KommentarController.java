package ch.bbw.as.bookmerkerbackend.kommentar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Das ist der Controller fuer die Kommentare.
 * 
 * @author Alex Schaub
 * @version 1.0
 */
@RestController
@RequestMapping("/comments")
public class KommentarController {
	/**
	 * Das ist das Repository fuer die Kommentarn.
	 */
	@Autowired
	private KommentarRepository kommentarRepository;

	public KommentarController(KommentarRepository kommentarRepository) {
		this.kommentarRepository = kommentarRepository;
	}

	/**
	 * Mit dieser Methode koennen alle Kommentarn geholt werden.
	 * 
	 * @return Es werden alle auf der Datenbank gespeicherte Kommentarn zurueckgegeben.
	 */
	@GetMapping
	public List<Kommentar> getAllComments() {
		return kommentarRepository.findAll();
	}
	
	/**
	 * Mit dieser Methode kann ein einzelnes Kommentar erfasst werden.
	 * 
	 * @param newKommentar Das ist das Kommentar, welches hinzugefuegt werden soll.
	 * @return Das neue Kommentar wird zurueckgegeben.
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Kommentar addComment(@RequestBody Kommentar newKommentar) {
		return kommentarRepository.save(newKommentar);
	}
}
