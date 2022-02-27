package BDBT_proj.Model;

public class Uzytkownicy {
	
	private String login;
	private String haslo;
	private String stanowisko;
	private int nrPracownika;

	public Uzytkownicy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Uzytkownicy( String login, String haslo, String stanowisko) {
		super();
		this.login = login;
		this.haslo = haslo;
		this.stanowisko = stanowisko;
	}
	
	public Uzytkownicy( String login, String haslo, String stanowisko, int nrPracownika) {
		super();
		this.login = login;
		this.haslo = haslo;
		this.stanowisko = stanowisko;
		this.nrPracownika = nrPracownika;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}
	
	public int getNrPracownika() {
		return nrPracownika;
	}

	public void setNrPracownika(int nrPracownika) {
		this.nrPracownika = nrPracownika;
	}

	@Override
	public String toString() {
		return "Uzytkownicy [login=" + login + ", haslo=" + haslo + ", stanowisko="
				+ stanowisko + "]";
	}
}
