package ch.bbw.as.bookmerkerbackend.benutzer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository fuer Benutzer
 * 
 * @author Alex Schaub
 * @version 1.0
 */
public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {
	
}