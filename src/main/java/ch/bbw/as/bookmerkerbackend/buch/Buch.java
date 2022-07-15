package ch.bbw.as.bookmerkerbackend.buch;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Dieses Entitaet stellt ein einzelnes Buch dar.
 * 
 * @author Alex Schaub
 * @version 1.0
 */
@Entity
public class Buch {
	/**
	 * Das ist die Id eines Buches. Die Id wird automatisch generiert.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * Das ist die URL zum Thumbnail fuer des Buchs.
     */
    private String url_thumbnail;
    
    /**
     * Das ist die URL zum Bild fuer des Buchs.
     */
    private String url_bild;
    
    /**
     * Das ist der Titel dieses Buchs.
     */
    @NotBlank(message = "Der Titel eines Buches muss erfasst werden.")
    @Size(max = 1000, message = "Der Zeichenanzahl darf nicht groesser als 1000 sein.")
    private String buchtitel;
    
    /**
     * Das ist eine kurze Beschreibung fuer dieses Buch.
     */
    @Size(max = 1000, message = "Der Zeichenanzahl darf nicht groesser als 1000 sein.")
    private String beschreibung;
    
    /**
     * Das ist die Seitenanzahl dieses Buchs.
     */
    private int seitenzahl;
    
    /**
     * Das ist die ISBN-Nummer dieses Buchs.
     */
    private long isbn;

    protected Buch() {
    	
    }
    
	public Buch(String url_thumbnail, String url_bild, @NotBlank @Size(max = 1000) String buchtitel,
			@Size(max = 1000) String beschreibung, int seitenzahl, long isbn) {
		super();
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
