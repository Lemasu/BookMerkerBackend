package ch.bbw.as.bookmerkerbackend.erinnerung;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ch.bbw.as.bookmerkerbackend.benutzer.Benutzer;
import ch.bbw.as.bookmerkerbackend.buch.Buch;

@Entity
public class Erinnerung {
	/**
	 * Das ist die Id eines Buches. Die Id wird automatisch generiert.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JsonBackReference
    private Benutzer benutzer;
    
    private LocalDateTime faellig_am;
    
    @ManyToMany
    private Set<Buch> buecher;

    protected Erinnerung() {
    	
    }
    
	public Erinnerung(Benutzer benutzer, LocalDateTime faellig_am, Set<Buch> buecher) {
		super();
		this.benutzer = benutzer;
		this.faellig_am = faellig_am;
		this.buecher = buecher;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public LocalDateTime getFaellig_am() {
		return faellig_am;
	}

	public void setFaellig_am(LocalDateTime faellig_am) {
		this.faellig_am = faellig_am;
	}

	public Set<Buch> getBuecher() {
		return buecher;
	}

	public void setBuecher(Set<Buch> buecher) {
		this.buecher = buecher;
	}
}
