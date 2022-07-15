package ch.bbw.as.bookmerkerbackend.benutzer;

class BenutzerNotFoundException extends RuntimeException {
	BenutzerNotFoundException(Long id) {
		super("Could not find user " + id);
	}
}
