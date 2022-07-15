package ch.bbw.as.bookmerkerbackend.buch;

/**
 * Das ist die Exception, welcher geworfen wird, wenn ein Buch nicht gefunden wurde.
 * 
 * @author Alex Schaub
 * @version 1.0
 */
class BuchNotFoundException extends RuntimeException {
	/**
	 * Das ist der Konstruktor fuer diese Exception.
	 * 
	 * @param id Das ist die Id des Buches, welcher nicht gefunden werden konnte.
	 */
	BuchNotFoundException(Long id) {
		super("Could not find book " + id);
	}
}
