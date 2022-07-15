package ch.bbw.as.bookmerkerbackend.buch;

class BuchNotFoundException extends RuntimeException {
	BuchNotFoundException(Long id) {
		super("Could not find book " + id);
	}
}
