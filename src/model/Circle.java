package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Circle extends PovrsinskiOblik {
	private Tacka centar;
	private int poluprecnik;

	public Circle() {

	}

	public Circle(Tacka centar, int poluprecnik) {
		this.centar = centar;
		this.poluprecnik = poluprecnik;
	}

	public Circle(Tacka centar, int poluprecnik, Color boja) {
		this(centar, poluprecnik);
		setBoja(boja);
	}

	public Circle(Tacka centar, int poluprecnik, Color boja, Color bojaUnutrasnjosti) {
		this(centar, poluprecnik, boja);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public void provera() throws Exception {
		if (this.getCentar().getX() < 0 | this.getCentar().getY() < 0 | poluprecnik < 0) {
			throw new Exception("Unete vrednosti su negativne!");
		}
	}

	public void pomeriNa(int x, int y) {
		centar.pomeriNa(x, y);
	}

	public void pomeriZa(int poX, int poY) {
		centar.pomeriZa(poX, poY);
	}

	public double povrsina() {
		return poluprecnik * poluprecnik * Math.PI;
	}

	public double obim() {
		return 2 * poluprecnik * Math.PI;
	}

	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawOval(centar.getX() - poluprecnik, centar.getY() - poluprecnik, 2 * poluprecnik, 2 * poluprecnik);

		if (isSelektovan())
			selektovan(g);
	}

	public void selektovan(Graphics g) {
		new Linija(new Tacka(centar.getX(), centar.getY() - poluprecnik),
				new Tacka(centar.getX(), centar.getY() + poluprecnik)).selektovan(g);
		new Linija(new Tacka(centar.getX() - poluprecnik, centar.getY()),
				new Tacka(centar.getX() + poluprecnik, centar.getY())).selektovan(g);
	}

	public boolean sadrzi(int x, int y) {
		if (new Tacka(x, y).udaljenost(getCentar()) <= poluprecnik)
			return true;
		else
			return false;
	}

	public void popuni(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillOval(centar.getX() - poluprecnik + 1, centar.getY() - poluprecnik + 1, 2 * poluprecnik - 2,
				2 * poluprecnik - 2);
	}

	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (int) (this.poluprecnik - ((Circle) o).poluprecnik);
		} else
			return 0;
	}

	public Tacka getCentar() {
		return centar;
	}

	public void setCentar(Tacka centar) {
		this.centar = centar;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

	public String toString() {
		return "Centar=" + centar + ", poluprecnik = " + poluprecnik;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle prosledjen = (Circle) obj;
			if (centar.equals(prosledjen.centar) && poluprecnik == prosledjen.poluprecnik)
				return true;
			else
				return false;
		} else
			return false;
	}

}