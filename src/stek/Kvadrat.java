package stek;

import model.Tacka;

public class Kvadrat implements Comparable<Kvadrat> {
	private Tacka goreLevo;
	private int duzina;
	private String bojaIvice;
	private String bojaUnutrasnjosti;

	public Kvadrat(Tacka goreLevo, int duzina, String bojaIvice, String bojaUnutrasnjosti) {
		this.goreLevo = goreLevo;
		this.duzina = duzina;
		this.bojaIvice = bojaIvice;
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}

	public void provera() throws Exception {
		if (this.getGoreLevo().getX() < 0 | this.getGoreLevo().getY() < 0 | duzina < 0) {
			throw new Exception("Unete vrednosti su negativne!");
		}
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}

	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}

	public int getDuzina() {
		return duzina;
	}

	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}

	public String getBojaIvice() {
		return bojaIvice;
	}

	public void setBojaIvice(String bojaIvice) {
		this.bojaIvice = bojaIvice;
	}

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}

	public String toString() {
		return "Kvadrat: tacka gore levo =" + goreLevo + ", duzina stranice=" + duzina + ", boja ivice=" + bojaIvice
				+ ", boja unutrasnjosti=" + bojaUnutrasnjosti + ".";
	}

	public int compareTo(Kvadrat kvadrat) {
		int duzina = ((Kvadrat) kvadrat).getDuzina();
		return this.getDuzina() - duzina;
	}
}