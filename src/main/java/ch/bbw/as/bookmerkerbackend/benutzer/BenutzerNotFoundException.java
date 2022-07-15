package ch.bbw.as.bookmerkerbackend.benutzer;

/**
 * Das ist die Exception, welcher geworfen wird, wenn ein Benutzer nicht gefunden wurde.
 * 
 * @author Alex Schaub
 * @version 1.0
 */
class BenutzerNotFoundException extends RuntimeException {
	/**
	 * Das ist der Konstruktor fuer diese Exception.
	 * 
	 * @param id Das ist die Id des Benutzers, welcher nicht gefunden werden konnte.
	 */
	BenutzerNotFoundException(Long id) {
		super("Could not find user " + id);
	}
}
