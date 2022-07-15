package ch.bbw.as.bookmerkerbackend;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.bbw.as.bookmerkerbackend.benutzer.Benutzer;
import ch.bbw.as.bookmerkerbackend.benutzer.BenutzerRepository;
import ch.bbw.as.bookmerkerbackend.buch.Buch;
import ch.bbw.as.bookmerkerbackend.buch.BuchRepository;

/**
 * Ueber diese Klasse wird die Applikation BookMerkerBackend gestartet.
 * 
 * @author Alex Schaub
 * @version 1.0
 */
@SpringBootApplication
public class BookMerkerBackendApplication {
	/**
	 * Das ist der Logger, welcher benoetigt wird, um zu loggen
	 */
	Logger logger = LoggerFactory.getLogger(BookMerkerBackendApplication.class);

	/**
	 * Ueber die Main-Methode wird diese Applikation gestartet.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BookMerkerBackendApplication.class, args);
	}
	
	/**
	 * Mit diesem CommandLineRunner werden Beispieldaten in die Datenbank geschrieben.
	 * 
	 * @param buchRepository Das ist das Repository fuer die Buecher.
	 * @return Dieser CommandLineRunner wird zurueckgegeben, damit sie beim Aufstarten dieser Applikation laufen gelassen werden kann.
	 */
	@Bean
	public CommandLineRunner demo(BuchRepository buchRepository, BenutzerRepository benutzerRepository) {
		return (args) -> {
			Buch buch1 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 1", "Beschreibung von Buch 1", 100, 9783966450300L, new HashSet<>());
			Buch buch2 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 2", "Beschreibung von Buch 2", 200, 9783966450301L, new HashSet<>());
			Buch buch3 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 3", "Beschreibung von Buch 3", 300, 9783966450302L, new HashSet<>());
			Buch buch4 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 4", "Beschreibung von Buch 4", 400, 9783966450303L, new HashSet<>());
			Buch buch5 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 5", "Beschreibung von Buch 5", 500, 9783966450304L, new HashSet<>());

			buchRepository.save(buch1);
			buchRepository.save(buch2);
			buchRepository.save(buch3);
			buchRepository.save(buch4);
			buchRepository.save(buch5);
			
			Benutzer benutzer = new Benutzer("abc", "abc", false, new HashSet<>(Arrays.asList(buch1)));
			benutzerRepository.save(benutzer);

			logger.info("Beispieldaten geladen");
		};
	}

}
