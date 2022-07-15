package ch.bbw.as.bookmerkerbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.bbw.as.bookmerkerbackend.buch.Buch;
import ch.bbw.as.bookmerkerbackend.buch.BuchRepository;

@SpringBootApplication
public class BookMerkerBackendApplication {
	Logger logger = LoggerFactory.getLogger(BookMerkerBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookMerkerBackendApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BuchRepository buchRepository) {
		return (args) -> {
			Buch buch1 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 1", "Beschreibung von Buch 1", 100, 9783966450300L);
			Buch buch2 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 2", "Beschreibung von Buch 2", 200, 9783966450301L);
			Buch buch3 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 3", "Beschreibung von Buch 3", 300, 9783966450302L);
			Buch buch4 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 4", "Beschreibung von Buch 4", 400, 9783966450303L);
			Buch buch5 = new Buch("https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-08.jpeg", "https://assets.thalia.media/img/artikel/1b6d07a88e703c10653d70dfa99cdafba22e2b89-00-00.jpeg", "Buch 5", "Beschreibung von Buch 5", 500, 9783966450304L);

			buchRepository.save(buch1);
			buchRepository.save(buch2);
			buchRepository.save(buch3);
			buchRepository.save(buch4);
			buchRepository.save(buch5);

			logger.info("Beispieldaten geladen");
		};
	}

}
