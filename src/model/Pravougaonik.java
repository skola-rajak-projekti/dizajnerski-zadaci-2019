package model;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends KvadratG {
	private int sirina;

	public Pravougaonik() {

	}

	public Pravougaonik(Tacka goreLevo, int sirina, int visina) {
		super.goreLevo = goreLevo;
		this.sirina = sirina;
		stranica = visina;
	}

	public Pravougaonik(Tacka goreLevo, int sirina, int visina, Color boja) {
		this(goreLevo, sirina, visina);
		setBoja(boja);
	}

	public Pravougaonik(Tacka goreLevo, int sirina, int visina, Color boja, Color bojaUnutrasnjosti) {
		this(goreLevo, sirina, visina, boja);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public void provera() throws Exception {
		if (this.getGoreLevo().getY() < 0 | this.getGoreLevo().getX() < 0 | stranica < 0 | this.getSirina() < 0) {
			throw new Exception("Unete vrednosti su negativne!");
		}
	}

	public void pomeriNa(int x, int y) {
		goreLevo.pomeriNa(x, y);
	}

	public void pomeriZa(int poX, int poY) {
		goreLevo.pomeriZa(poX, poY);
	}

	public double povrsina() {
		return stranica * sirina;
	}

	public double obim() {
		return 2 * stranica + 2 * sirina;
	}

	public String toString() {
		return "Tacka gore levo=" + goreLevo + ", sirina= " + sirina + ", visina= " + stranica;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Pravougaonik) {
			Pravougaonik prosledjen = (Pravougaonik) obj;
			if (goreLevo.equals(prosledjen.goreLevo) && stranica == prosledjen.stranica && sirina == prosledjen.sirina)
				return true;
			else
				return false;
		} else
			return false;
	}

	public Linija dijagonala() {
		Tacka doleDesno = new Tacka(goreLevo.getX() + sirina, goreLevo.getY() + stranica);
		return new Linija(goreLevo, doleDesno);
	}

	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), sirina, stranica);
		if (isSelektovan())
			selektovan(g);
	}

	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX() + sirina, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY() + stranica)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX() + sirina, getGoreLevo().getY()), dijagonala().getKrajnja())
				.selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY() + stranica), dijagonala().getKrajnja())
				.selektovan(g);
	}

	public void popuni(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX() + 1, goreLevo.getY() + 1, sirina - 1, stranica - 1);
	}

	public boolean sadrzi(int x, int y) {
		if (this.getGoreLevo().getX() <= x && this.getGoreLevo().getX() + sirina >= x && this.getGoreLevo().getY() <= y
				&& this.getGoreLevo().getY() + stranica >= y)
			return true;
		else
			return false;
	}

	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		this.sirina = sirina;
	}
}