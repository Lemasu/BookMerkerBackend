package ch.bbw.as.bookmerkerbackend.erinnerung;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository fuer Erinnerungen
 * 
 * @author Alex Schaub
 * @version 1.0
 */
public interface ErinnerungRepository extends JpaRepository<Erinnerung, Long> {
	
}