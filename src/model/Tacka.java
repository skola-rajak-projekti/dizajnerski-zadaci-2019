package model;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik {
	private int x;
	private int y;

	public Tacka() {

	}

	public Tacka(int x, int y) {
		this.x = x;
		setY(y);
	}

	public Tacka(int x, int y, Color boja) {
		this(x, y);
		setBoja(boja);
	}

	// Implementacija apstraktnih metoda iz interfejsa Pomerljiv
	public void pomeriNa(int x, int y) {
		this.x = x;
		setY(y);
	}

	public void pomeriZa(int poX, int poY) {
		this.x += poX;
		this.y = this.y + poY;
	}

	public double udaljenost(Tacka t) {
		int dX = x - t.x;
		int dY = t.y - y;
		double d = Math.sqrt(dX * dX + dY * dY);
		return d;
	}

	public void provera() throws Exception {
		if (this.getX() < 0 | this.getY() < 0) {
			throw new Exception("Unete vrednosti su negativne!");
		}
	}

	// Implementacija apstraktnih metoda iz apstraktne klase Oblik
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(x - 2, y, x + 2, y);

		g.drawLine(x, y + 2, x, y - 2);

		if (isSelektovan())
			selektovan(g);
	}

	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x - 3, y - 3, 6, 6);
	}

	public boolean sadrzi(int x, int y) {
		if (this.udaljenost(new Tacka(x, y)) <= 2)
			return true;
		else
			return false;
	}

	//Implementacija apstraktne metode iz interfejsa Comparable
	public int compareTo(Object o) {
		if (o instanceof Tacka) {
			Tacka pocetak = new Tacka(0, 0);
			return (int) (this.udaljenost(pocetak) - ((Tacka) o).udaljenost(pocetak));
		} else
			return 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int novoX) {
		x = novoX;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tacka) {
			Tacka prosledjena = (Tacka) obj;
			if (x == prosledjena.getX() && y == prosledjena.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}