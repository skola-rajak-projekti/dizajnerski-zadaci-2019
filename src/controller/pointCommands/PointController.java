package controller.pointCommands;

import model.Oblik;
import model.Tacka;
import view.DlgModifikujTacku;
import view.PnlCrtez;

public class PointController {

	public static void modifySelectedPoint(PnlCrtez pnlCrtanje, Oblik oblik, int i) {
		DlgModifikujTacku modifikujTacku = new DlgModifikujTacku();

		modifikujTacku.getTxtXkoordinata().setText(((Tacka) oblik).getX() + "");
		modifikujTacku.getTxtYkoordinata().setText(((Tacka) oblik).getY() + "");
		modifikujTacku.getBtnBojaIvice().setBackground(oblik.getBoja());
		modifikujTacku.setVisible(true);
		if (modifikujTacku.tempOdustani == false) {
			pnlCrtanje.listaOblika.remove(oblik);
			pnlCrtanje.listaOblika.add(modifikujTacku.tacka);
		} else if (modifikujTacku.tempOdustani == true) {
			for (int j = pnlCrtanje.listaOblika.size() - 1; j >= 0; j--) {
				if (pnlCrtanje.listaOblika.get(i).isSelektovan() == true) {
					pnlCrtanje.listaOblika.get(i).setSelektovan(false);
					j = 0;
				}
			}
		}
	}
	
	public static void deleteSelectedPoint() {
		
	}

}
