package controller.rectangleCommands;

import model.Oblik;
import model.Pravougaonik;
import view.DlgModifikujPravougaonik;
import view.PnlCrtez;

public class RectangleController {

	public static void modifySelectedRectangle(PnlCrtez pnlCrtanje, Oblik oblik, int i)  {
		DlgModifikujPravougaonik modifikujPravougaonik = new DlgModifikujPravougaonik();

		modifikujPravougaonik.getTxtXkoordinata()
				.setText(((Pravougaonik) oblik).getGoreLevo().getX() + "");
		modifikujPravougaonik.getTxtYkoordinata()
				.setText(((Pravougaonik) oblik).getGoreLevo().getY() + "");
		modifikujPravougaonik.getTxtSirina().setText(((Pravougaonik) oblik).getSirina() + "");
		modifikujPravougaonik.getTxtVisina().setText(((Pravougaonik) oblik).getStranica() + "");
		modifikujPravougaonik.getBtnBojaIvice().setBackground(oblik.getBoja());
		modifikujPravougaonik.getBtnBojaUnutrasnjosti()
				.setBackground(((Pravougaonik) oblik).getBojaUnutrasnjosti());
		modifikujPravougaonik.setVisible(true);
		if (modifikujPravougaonik.tempOdustani == false) {
			pnlCrtanje.listaOblika.remove(oblik);
			pnlCrtanje.listaOblika.add(modifikujPravougaonik.pravougaonik);
		} else if (modifikujPravougaonik.tempOdustani == true) {
			for (int j = pnlCrtanje.listaOblika.size() - 1; j >= 0; j--) {
				if (pnlCrtanje.listaOblika.get(i).isSelektovan() == true) {
					pnlCrtanje.listaOblika.get(i).setSelektovan(false);
					j = 0;
				}
			}
		}
	
	}
}
