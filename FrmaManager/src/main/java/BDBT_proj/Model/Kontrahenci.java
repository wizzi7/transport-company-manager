package BDBT_proj.Model;

public class Kontrahenci {
	
	private int nrKontrahenta;
	private String nazwaKontrahenta;
	private String email;
	private String miasto;
	private String ulica;
	private String nrLokalu;
	private String kodPocztowy;
	private String kraj;
	private int nrAdresu;
	
	public Kontrahenci() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Kontrahenci(int nrKontrahenta, String nazwaKontrahenta, String email, String miasto, String ulica,
			String nrLokalu, String kodPocztowy, String kraj, int nrAdresu) {
		super();
		this.nrKontrahenta = nrKontrahenta;
		this.nazwaKontrahenta = nazwaKontrahenta;
		this.email = email;
		this.miasto = miasto;
		this.ulica = ulica;
		this.nrLokalu = nrLokalu;
		this.kodPocztowy = kodPocztowy;
		this.kraj = kraj;
		this.nrAdresu = nrAdresu;
	}
	
	public int getNrKontrahenta() {
		return nrKontrahenta;
	}
	
	public void setNrKontrahenta(int nrKontrahenta) {
		this.nrKontrahenta = nrKontrahenta;
	}
	
	public String getNazwaKontrahenta() {
		return nazwaKontrahenta;
	}
	
	public void setNazwaKontrahenta(String nazwaKontrahenta) {
		this.nazwaKontrahenta = nazwaKontrahenta;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMiasto() {
		return miasto;
	}
	
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	
	public String getUlica() {
		return ulica;
	}
	
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	
	public String getNrLokalu() {
		return nrLokalu;
	}
	
	public void setNrLokalu(String nrLokalu) {
		this.nrLokalu = nrLokalu;
	}
	
	public String getKodPocztowy() {
		return kodPocztowy;
	}
	
	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}
	
	public String getKraj() {
		return kraj;
	}
	
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	
	public int getNrAdresu() {
		return this.nrAdresu;
	}
	
	public void setNrAdresu(int nrAdresu) {
		this.nrAdresu = nrAdresu;
	}
}
