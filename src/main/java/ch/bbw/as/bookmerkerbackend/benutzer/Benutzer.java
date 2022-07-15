package ch.bbw.as.bookmerkerbackend.benutzer;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ch.bbw.as.bookmerkerbackend.buch.Buch;

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

    protected Benutzer() {
    	
    }

	public Benutzer(String benutzername, String passwort, boolean admin, Set<Buch> buchliste) {
		this.benutzername = benutzername;
		this.passwort = passwort;
		this.admin = admin;
		this.buchliste = buchliste;
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
}
