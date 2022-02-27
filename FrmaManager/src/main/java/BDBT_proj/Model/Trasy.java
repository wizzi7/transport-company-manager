package BDBT_proj.Model;

import java.util.Date;

public class Trasy {
	
	private int nrPracownika;
	private String imie;
	private String nazwisko;
	private String krajZaladunku;
	private Date dataZaladunku;
	private String krajRozladunku;
	private Date dataRozladunku;
	private String nrRejestracyjny;
	private String nazwaMarki;
	
	public Trasy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Trasy(int nrPracownika, String imie, String nazwisko, String krajZaladunku, Date dataZaladunku,
			String krajRozladunku, Date dataRozladunku, String nrRejestracyjny, String nazwaMarki) {
		super();
		this.nrPracownika = nrPracownika;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.krajZaladunku = krajZaladunku;
		this.dataZaladunku = dataZaladunku;
		this.krajRozladunku = krajRozladunku;
		this.dataRozladunku = dataRozladunku;
		this.nrRejestracyjny = nrRejestracyjny;
		this.nazwaMarki = nazwaMarki;
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
	
	public String getKrajZaladunku() {
		return krajZaladunku;
	}
	
	public void setKrajZaladunku(String krajZaladunku) {
		this.krajZaladunku = krajZaladunku;
	}
	
	public Date getDataZaladunku() {
		return dataZaladunku;
	}
	
	public void setDataZaladunku(Date dataZaladunku) {
		this.dataZaladunku = dataZaladunku;
	}
	
	public String getKrajRozladunku() {
		return krajRozladunku;
	}
	
	public void setKrajRozladunku(String krajRozladunku) {
		this.krajRozladunku = krajRozladunku;
	}
	
	public Date getDataRozladunku() {
		return dataRozladunku;
	}
	
	public void setDataRozladunku(Date dataRozladunku) {
		this.dataRozladunku = dataRozladunku;
	}
	
	public String getNrRejestracyjny() {
		return nrRejestracyjny;
	}
	
	public void setNrRejestracyjny(String nrRejestracyjny) {
		this.nrRejestracyjny = nrRejestracyjny;
	}
	
	public String getNazwaMarki() {
		return nazwaMarki;
	}
	
	public void setNazwaMarki(String nazwaMarki) {
		this.nazwaMarki = nazwaMarki;
	}
}
