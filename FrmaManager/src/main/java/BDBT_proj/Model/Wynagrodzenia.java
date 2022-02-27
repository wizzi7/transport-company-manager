package BDBT_proj.Model;

public class Wynagrodzenia {
	
	private int nrWynagrodzenia;
	private int nrPracownika;
	private String imie;
	private String nazwisko;
	private int kwotaPodstawowa;
	private int kwotaDodatkowa;
	
	public Wynagrodzenia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Wynagrodzenia(int nrWynagrodzenia,int nrPracownika, int kwotaPodstawowa, int kwotaDodatkowa) {
		super();
		this.nrWynagrodzenia = nrWynagrodzenia;
		this.nrPracownika = nrPracownika;
		this.kwotaPodstawowa = kwotaPodstawowa;
		this.kwotaDodatkowa = kwotaDodatkowa;
	}

	public Wynagrodzenia(int nrWynagrodzenia,int nrPracownika, String imie, String nazwisko, int kwotaPodstawowa, int kwotaDodatkowa) {
		super();
		this.nrWynagrodzenia = nrWynagrodzenia;
		this.nrPracownika = nrPracownika;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.kwotaPodstawowa = kwotaPodstawowa;
		this.kwotaDodatkowa = kwotaDodatkowa;
	}
	
	public int getNrWynagrodzenia() {
		return nrWynagrodzenia;
	}

	public void setNrWynagrodzenia(int nrWynagrodzenia) {
		this.nrWynagrodzenia = nrWynagrodzenia;
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

	public int getKwotaPodstawowa() {
		return kwotaPodstawowa;
	}

	public void setKwotaPodstawowa(int kwotaPodstawowa) {
		this.kwotaPodstawowa = kwotaPodstawowa;
	}

	public int getKwotaDodatkowa() {
		return kwotaDodatkowa;
	}

	public void setKwotaDodatkowa(int kwotaDodatkowa) {
		this.kwotaDodatkowa = kwotaDodatkowa;
	}
}
