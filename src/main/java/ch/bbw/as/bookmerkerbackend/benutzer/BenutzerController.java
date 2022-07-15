package ch.bbw.as.bookmerkerbackend.benutzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class BenutzerController {
	@Autowired
	private BenutzerRepository benutzerRepository;

	public BenutzerController(BenutzerRepository benutzerRepository) {
		this.benutzerRepository = benutzerRepository;
	}
}
