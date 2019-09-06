package model;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik {
	private Tacka pocetna;
	private Tacka krajnja;

	public Linija() {

	}

	public Linija(Tacka pocetna, Tacka krajnja) {
		this.pocetna = pocetna;
		this.krajnja = krajnja;
	}

	public Linija(Tacka pocetna, Tacka krajnja, Color boja) {
		this(pocetna, krajnja);
		setBoja(boja);
	}

	public void provera() throws Exception {
		if (this.getPocetna().getX() < 0 | this.getKrajnja().getX() < 0 | this.getPocetna().getY() < 0
				| this.getKrajnja().getY() < 0) {
			throw new Exception("Unete vrednosti su negativne!");
		}
	}

	public void pomeriZa(int poX, int poY) {
		pocetna.pomeriZa(poX, poY);
		krajnja.pomeriZa(poX, poY);
	}

	public void pomeriNa(int x, int y) {
		pocetna.pomeriNa(x, y);
		krajnja.pomeriNa(x, y);
	}

	public double duzina() {
		return pocetna.udaljenost(krajnja);
	}

	public Tacka sredinaLinije() {
		int xSredine = (pocetna.getX() + krajnja.getX()) / 2;
		int ySredine = (pocetna.getY() + krajnja.getY()) / 2;
		Tacka sredinaLinije = new Tacka(xSredine, ySredine);
		return sredinaLinije;
	}

	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(pocetna.getX(), pocetna.getY(), krajnja.getX(), krajnja.getY());
		if (isSelektovan())
			selektovan(g);
	}

	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		pocetna.selektovan(g);
		krajnja.selektovan(g);
		sredinaLinije().selektovan(g);
	}

	public boolean sadrzi(int x, int y) {
		Tacka pomocna = new Tacka(x, y);
		if (pocetna.udaljenost(pomocna) + krajnja.udaljenost(pomocna) - duzina() <= 1)
			return true;
		else
			return false;

	}

	public int compareTo(Object o) {
		if (o instanceof Linija) {
			return (int) (this.duzina() - ((Linija) o).duzina());
		} else
			return 0;
	}

	public Tacka getPocetna() {
		return pocetna;
	}

	public void setPocetna(Tacka pocetna) {
		this.pocetna = pocetna;
	}

	public Tacka getKrajnja() {
		return krajnja;
	}

	public void setKrajnja(Tacka krajnja) {
		this.krajnja = krajnja;
	}

	public String toString() {
		return pocetna + "->" + krajnja;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Linija) {
			Linija prosledjena = (Linija) obj;
			if (pocetna.equals(prosledjena.pocetna) && krajnja.equals(prosledjena.krajnja))
				return true;
			else
				return false;
		} else
			return false;
	}
}