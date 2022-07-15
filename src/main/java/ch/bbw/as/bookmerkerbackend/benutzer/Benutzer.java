package ch.bbw.as.bookmerkerbackend.benutzer;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ch.bbw.as.bookmerkerbackend.buch.Buch;
import ch.bbw.as.bookmerkerbackend.erinnerung.Erinnerung;
import ch.bbw.as.bookmerkerbackend.kommentar.Kommentar;

@Entity
public class Benutzer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String benutzername;
    
    private String passwort;
    
    private boolean admin;
    
    @ManyToMany
    @JsonManagedReference
    private Set<Buch> buchliste;
    
    @OneToMany(mappedBy = "benutzer")
    @JsonManagedReference
    private Set<Erinnerung> erinnerungen;
    
    @OneToMany(mappedBy = "verfasser")
    private Set<Kommentar> kommentare;

    protected Benutzer() {
    	
    }
	
	public Benutzer(String benutzername, String passwort, boolean admin, Set<Buch> buchliste,
			Set<Erinnerung> erinnerungen, Set<Kommentar> kommentare) {
		super();
		this.benutzername = benutzername;
		this.passwort = passwort;
		this.admin = admin;
		this.buchliste = buchliste;
		this.erinnerungen = erinnerungen;
		this.kommentare = kommentare;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Set<Buch> getBuchliste() {
		return buchliste;
	}

	public void setBuchliste(Set<Buch> buchliste) {
		this.buchliste = buchliste;
	}

	public Set<Erinnerung> getErinnerungen() {
		return erinnerungen;
	}

	public void setErinnerungen(Set<Erinnerung> erinnerungen) {
		this.erinnerungen = erinnerungen;
	}

	public Set<Kommentar> getKommentare() {
		return kommentare;
	}

	public void setKommentare(Set<Kommentar> kommentare) {
		this.kommentare = kommentare;
	}
}
