package ch.bbw.as.bookmerkerbackend.buch;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Buch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String url_thumbnail;
    
    private String url_bild;
    
    @NotEmpty
    @Size(max = 1000)
    private String buchtitel;
    
    @Size(max = 1000)
    private String beschreibung;
    
    private int seitenzahl;
    
    private long isbn;

    protected Buch() {
    	
    }

	public Buch(String url_thumbnail, String url_bild, @Size(max = 1000) String buchtitel,
			@Size(max = 1000) String beschreibung, int seitenzahl, long isbn) {
		this.url_thumbnail = url_thumbnail;
		this.url_bild = url_bild;
		this.buchtitel = buchtitel;
		this.beschreibung = beschreibung;
		this.seitenzahl = seitenzahl;
		this.isbn = isbn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl_thumbnail() {
		return url_thumbnail;
	}

	public void setUrl_thumbnail(String url_thumbnail) {
		this.url_thumbnail = url_thumbnail;
	}

	public String getUrl_bild() {
		return url_bild;
	}

	public void setUrl_bild(String url_bild) {
		this.url_bild = url_bild;
	}

	public String getBuchtitel() {
		return buchtitel;
	}

	public void setBuchtitel(String buchtitel) {
		this.buchtitel = buchtitel;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public int getSeitenzahl() {
		return seitenzahl;
	}

	public void setSeitenzahl(int seitenzahl) {
		this.seitenzahl = seitenzahl;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
}
