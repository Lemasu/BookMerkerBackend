package ch.bbw.as.bookmerkerbackend.kommentar;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.bbw.as.bookmerkerbackend.benutzer.Benutzer;
import ch.bbw.as.bookmerkerbackend.buch.Buch;

@Entity
public class Kommentar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    private Buch buch;
    
    @ManyToOne
    private Benutzer verfasser;
    
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
