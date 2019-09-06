package model;

import java.awt.Color;
import java.awt.Graphics;

public class KvadratG extends PovrsinskiOblik {
	protected Tacka goreLevo;
	protected int stranica;

	public KvadratG() {

	}

	public KvadratG(Tacka goreLevo, int stranica) {
		this.goreLevo = goreLevo;
		this.stranica = stranica;
	}

	public KvadratG(Tacka goreLevo, int stranica, Color bojaIvice) {
		this(goreLevo, stranica);
		setBoja(bojaIvice);
	}

	public KvadratG(Tacka goreLevo, int stranica, Color bojaIvice, Color bojaUnutrasnjosti) {
		this(goreLevo, stranica, bojaIvice);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public void pomeriNa(int x, int y) {
		goreLevo.pomeriNa(x, y);
	}

	public void pomeriZa(int poX, int poY) {
		goreLevo.pomeriZa(poX, poY);
	}

	public double povrsina() {
		return stranica * stranica;
	}

	public double obim() {
		return 4 * stranica;
	}

	public Linija dijagonala() {
		Tacka doleDesno = new Tacka(goreLevo.getX() + stranica, goreLevo.getY() + stranica);
		return new Linija(goreLevo, doleDesno);
	}

	public Tacka centar() {
		return dijagonala().sredinaLinije();
	}

	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), stranica, stranica);
		if (isSelektovan())
			selektovan(g);
	}

	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX() + stranica, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY() + stranica)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX() + stranica, getGoreLevo().getY()), dijagonala().getKrajnja())
				.selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY() + stranica), dijagonala().getKrajnja())
				.selektovan(g);
	}

	public boolean sadrzi(int x, int y) {
		if (this.getGoreLevo().getX() <= x && this.getGoreLevo().getX() + stranica >= x
				&& this.getGoreLevo().getY() <= y && this.getGoreLevo().getY() + stranica >= y)
			return true;
		else
			return false;
	}

	public void provera() throws Exception {
		if (this.getGoreLevo().getX() < 0 | this.getGoreLevo().getY() < 0 | stranica < 0) {
			throw new Exception("Unete vrednosti su negativne!");
		}
	}

	public void popuni(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX() + 1, goreLevo.getY() + 1, stranica - 1, stranica - 1);
	}

	public int compareTo(Object o) {
		if (o instanceof KvadratG) {
			return (int) (this.povrsina() - ((KvadratG) o).povrsina());
		} else
			return 0;
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}

	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}

	public int getStranica() {
		return stranica;
	}

	public void setStranica(int stranica) {
		this.stranica = stranica;
	}

	public String toString() {
		return "Tacka gore levo=" + goreLevo + ", stranica = " + stranica + ", boja ivice = " + getBoja()
				+ ", boja unutrasnjosti = " + getBojaUnutrasnjosti();
	}

	public boolean equals(Object obj) {
		if (obj instanceof KvadratG) {
			KvadratG prosledjen = (KvadratG) obj;
			if (goreLevo.equals(prosledjen.goreLevo) && stranica == prosledjen.stranica)
				return true;
			else
				return false;
		} else
			return false;
	}
}