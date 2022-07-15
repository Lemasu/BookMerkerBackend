package ch.bbw.as.bookmerkerbackend.benutzer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Das ist der Controller fuer die Benutzer.
 * 
 * @author Alex Schaub
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
public class BenutzerController {
	/**
	 * Das ist das Repository fuer die Benutzern.
	 */
	@Autowired
	private BenutzerRepository benutzerRepository;

	public BenutzerController(BenutzerRepository benutzerRepository) {
		this.benutzerRepository = benutzerRepository;
	}

	/**
	 * Mit dieser Methode koennen alle Benutzern geholt werden.
	 * 
	 * @return Es werden alle auf der Datenbank gespeicherte Benutzern zurueckgegeben.
	 */
	@GetMapping
	public List<Benutzer> getAllUsers() {
		return benutzerRepository.findAll();
	}

	/**
	 * Mit dieser Methode kann ein einzelnes Benutzer geholt werden.
	 * 
	 * @param id Das ist die Id des Benutzeres, welcher geholt werden soll.
	 * @return Es wird ein Benutzer mit der gewuenschten Id zurueckgegeben.
	 */
	@GetMapping("/{id}")
	public Benutzer getBenutzerById(@PathVariable Long id) {
		return benutzerRepository.findById(id).orElseThrow(() -> new BenutzerNotFoundException(id));
	}

	/**
	 * Mit dieser Methode kann ein einzelnes Benutzer erfasst werden.
	 * 
	 * @param newBenutzer Das ist das Benutzer, welches hinzugefuegt werden soll.
	 * @return Das neue Benutzer wird zurueckgegeben.
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Benutzer addUser(@RequestBody Benutzer newBenutzer) {
		return benutzerRepository.save(newBenutzer);
	}

	/**
	 * Mit dieser Methode kann ein einzelnes Benutzer verändert werden.
	 * Falls es kein Benutzer mit der gewuenschten Id gibt, wird ein Benutzer mit dieser Id erfasst.
	 * 
	 * @param newBenutzer Das sind die veraenderte Daten.
	 * @param id Das ist die Id des Benutzeres, welches veraendert werden soll.
	 * @return Das veraenderte Benutzer wird zurueckgegeben.
	 */
	@PutMapping("/{id}")
	public Benutzer updateUser(@RequestBody Benutzer newBenutzer, @PathVariable Long id) {
		return benutzerRepository.findById(id).map(benutzer -> {
			benutzer.setBenutzername(newBenutzer.getBenutzername());
			benutzer.setPasswort(newBenutzer.getPasswort());
			benutzer.setAdmin(newBenutzer.isAdmin());
			return benutzerRepository.save(benutzer);
		}).orElseGet(() -> {
			newBenutzer.setId(id);
			return benutzerRepository.save(newBenutzer);
		});
	}
	
	/**
	 * Mit dieser Methode kann man ein einzelnen Benutzer loeschen.
	 * 
	 * @param id Das ist die Id des Benutzes, welches geloescht werden soll.
	 */
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		benutzerRepository.deleteById(id);
	}
}
