package ch.bbw.as.bookmerkerbackend.kommentar;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository fuer Kommentar
 * 
 * @author Alex Schaub
 * @version 1.0
 */
public interface KommentarRepository extends JpaRepository<Kommentar, Long> {
	
}