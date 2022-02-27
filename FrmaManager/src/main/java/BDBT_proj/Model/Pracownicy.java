package BDBT_proj.Model;

public class Pracownicy {
	
	private int nrPracownika;
	private String imie;
	private String nazwisko;
	private String narodowosc;
	private String pesel;
	private String nrTelefonu;
	private String plec;
	
	public Pracownicy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pracownicy(int nrPracownika, String imie, String nazwisko,  String narodowosc,
			String pesel, String nrTelefonu, String plec) {
		super();
		this.nrPracownika = nrPracownika;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.narodowosc = narodowosc;
		this.pesel = pesel;
		this.nrTelefonu = nrTelefonu;
		this.plec = plec;
	}
	
	public int getNrPracownika() {
		return nrPracownika;
	}
	
	public void setNrPracownika(int nrPracownika) {
		this.nrPracownika = nrPracownika;
	}
	
	public String getImie() {
		return imie;
	}
	
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public String getNarodowosc() {
		return narodowosc;
	}
	
	public void setNarodowosc(String narodowosc) {
		this.narodowosc = narodowosc;
	}
	
	public String getPesel() {
		return pesel;
	}
	
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public String getNrTelefonu() {
		return nrTelefonu;
	}
	
	public void setNrTelefonu(String nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}
	
	public String getPlec() {
		return plec;
	}
	
	public void setPlec(String plec) {
		this.plec = plec;
	}
	
	
	public Pracownicy getById(int nrPracownika) {
		return this;
	}
	
	@Override
	public String toString() {
		return "Pracownicy [nrPracownika=" + nrPracownika + ", imie=" + imie + ", nazwisko=" + nazwisko
				+ ", narodowosc=" + narodowosc + ", pesel=" + pesel
				+ ", nrTelefonu=" + nrTelefonu + ", plec=" + plec +  " ]";
	}
}
