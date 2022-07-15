package ch.bbw.as.bookmerkerbackend.buch;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Das ist das Repository fuer die Entitaet "Buch".
 * 
 * @author Alex Schaub
 * @version 1.0
 */
public interface BuchRepository extends JpaRepository<Buch, Long> {
	
}