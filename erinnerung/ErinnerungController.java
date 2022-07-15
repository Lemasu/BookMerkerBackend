package ch.bbw.as.bookmerkerbackend.erinnerung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reminders")
public class ErinnerungController {
	/**
	 * Das ist das Repository fuer die Erinnerungn.
	 */
	@Autowired
	private ErinnerungRepository erinnerungRepository;

	public ErinnerungController(ErinnerungRepository erinnerungRepository) {
		this.erinnerungRepository = erinnerungRepository;
	}

	/**
	 * Mit dieser Methode koennen alle Erinnerungn geholt werden.
	 * 
	 * @return Es werden alle auf der Datenbank gespeicherte Erinnerungn zurueckgegeben.
	 */
	@GetMapping
	public List<Erinnerung> getAllReminders() {
		return erinnerungRepository.findAll();
	}
	
	/**
	 * Mit dieser Methode kann ein einzelnes Erinnerung erfasst werden.
	 * 
	 * @param newErinnerung Das ist das Erinnerung, welches hinzugefuegt werden soll.
	 * @return Das neue Erinnerung wird zurueckgegeben.
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Erinnerung addReminder(@RequestBody Erinnerung newErinnerung) {
		return erinnerungRepository.save(newErinnerung);
	}
	
	/**
	 * Mit dieser Methode kann man ein einzelnen Erinnerung loeschen.
	 * 
	 * @param id Das ist die Id des Benutzes, welches geloescht werden soll.
	 */
	@DeleteMapping("/{id}")
	public void deleteReminder(@PathVariable Long id) {
		erinnerungRepository.deleteById(id);
	}
}
