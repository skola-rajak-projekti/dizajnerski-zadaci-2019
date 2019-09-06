package view;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.text.html.CSS;

import controller.circleCommands.ModifyCircleCommand;
import model.Circle;
import model.KvadratG;
import model.Oblik;
import model.Pravougaonik;

public class PnlCrtez extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	public static ArrayList<Oblik> listaOblika = new ArrayList<Oblik>();

	
	private boolean selektovanOblik;
	private PnlCrtez pnlCrtanje;


	/**
	 * Create the panel.
	 */
	public PnlCrtez() {

	}

	public void paint(Graphics g) {
		super.paint(g);
		Oblik trenutniOblik;
		Iterator<Oblik> it = listaOblika.iterator();
		while (it.hasNext()) {
			
			trenutniOblik = it.next();
			if (trenutniOblik instanceof KvadratG)
				((KvadratG) trenutniOblik).popuni(g);
			else if (trenutniOblik instanceof Pravougaonik)
				((Pravougaonik) trenutniOblik).popuni(g);
			else if (trenutniOblik instanceof Circle)
				((Circle) trenutniOblik).popuni(g);
			trenutniOblik.crtajSe(g);
		}
		repaint();
	}
	
	public void deselectAllShapes() {

		if (selektovanOblik) {
			for (int i = pnlCrtanje.listaOblika.size() - 1; i >= 0; i--) {
				if (pnlCrtanje.listaOblika.get(i).isSelektovan() == true) {
					pnlCrtanje.listaOblika.get(i).setSelektovan(false);
					selektovanOblik = false;
					i = 0;
				}
			}
		}
	}

	public static ArrayList<Oblik> getListaOblika() {
		return listaOblika;
	}

	

}