package ch.bbw.as.bookmerkerbackend.kommentar;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ch.bbw.as.bookmerkerbackend.benutzer.Benutzer;
import ch.bbw.as.bookmerkerbackend.buch.Buch;

/**
 * von Benutzer erfasste Kommentare
 * 
 * @author Alex Schaub
 * @version 1.0
 */
@Entity
public class Kommentar {
	/**
	 * Das ist die Id eines Kommentars. Die Id wird automatisch generiert.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * Buch, wofuer das Kommentar erfasst wurde
     */
    @ManyToOne
    @JsonManagedReference
    private Buch buch;
    
    /**
     * Benutzer, welcher diesen Kommentar erfasst hatte
     */
    @ManyToOne
    @JsonManagedReference
    private Benutzer verfasser;
    
    /**
     * Zeitpunkt, an welchem das Kommentar erfasst wurde
     */
    private LocalDateTime verfasst_am;

    protected Kommentar() {
    	
    }
    
	public Kommentar(Buch buch, Benutzer verfasser, LocalDateTime verfasst_am) {
		super();
		this.buch = buch;
		this.verfasser = verfasser;
		this.verfasst_am = verfasst_am;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Buch getBuch() {
		return buch;
	}

	public void setBuch(Buch buch) {
		this.buch = buch;
	}

	public Benutzer getVerfasser() {
		return verfasser;
	}

	public void setVerfasser(Benutzer verfasser) {
		this.verfasser = verfasser;
	}

	public LocalDateTime getVerfasst_am() {
		return verfasst_am;
	}

	public void setVerfasst_am(LocalDateTime verfasst_am) {
		this.verfasst_am = verfasst_am;
	}
}
