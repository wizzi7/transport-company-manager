package BDBT_proj.Model;

public class Adresy {

	private int nrAdresu;
	private String miasto;
	private String ulica;
	private String nrLokalu;
	private String kodPocztowy;
	private String kraj;
	
	public Adresy() {
		super();
	}

	public Adresy(int nrAdresu, String miasto, String ulica, String nrLokalu, String kodPocztowy, String kraj) {
		super();
		this.nrAdresu = nrAdresu;
		this.miasto = miasto;
		this.ulica = ulica;
		this.nrLokalu = nrLokalu;
		this.kodPocztowy = kodPocztowy;
		this.kraj = kraj;
	}

	public int getNrAdresu() {
		return nrAdresu;
	}

	public void setNrAdresu(int nrAdresu) {
		this.nrAdresu = nrAdresu;
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

	@Override
	public String toString() {
		return "Adresy [nrAdresu=" + nrAdresu + ", miasto=" + miasto + ", ulica=" + ulica + ", nrLokalu=" + nrLokalu
				+ ", kodPocztowy=" + kodPocztowy + ", kraj=" + kraj + "]";
	}
}
