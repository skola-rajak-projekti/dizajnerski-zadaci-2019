package controller.squareCommands;

import model.KvadratG;
import model.Oblik;
import view.DlgModifikujKvadrat;
import view.PnlCrtez;

public class SquareController {
	public static void modifySelectedSquare(PnlCrtez pnlCrtanje, Oblik oblik, int i) {
		DlgModifikujKvadrat modifikujKvadrat = new DlgModifikujKvadrat();

		modifikujKvadrat.getTxtXkoordinata()
				.setText(((KvadratG) oblik).getGoreLevo().getX() + "");
		modifikujKvadrat.getTxtYkoordinata()
				.setText(((KvadratG) oblik).getGoreLevo().getY() + "");
		modifikujKvadrat.getTxtDuzina().setText(((KvadratG) oblik).getStranica() + "");
		modifikujKvadrat.getBtnBojaIvice().setBackground(oblik.getBoja());
		modifikujKvadrat.getBtnBojaUnutrasnjosti()
				.setBackground(((KvadratG) oblik).getBojaUnutrasnjosti());

		modifikujKvadrat.setVisible(true);
		if (modifikujKvadrat.tempOdustani == false) {
			pnlCrtanje.listaOblika.remove(oblik);
			pnlCrtanje.listaOblika.add(modifikujKvadrat.kvadrat);

		} else if (modifikujKvadrat.tempOdustani == true) {
			for (int j = pnlCrtanje.listaOblika.size() - 1; j >= 0; j--) {
				if (pnlCrtanje.listaOblika.get(i).isSelektovan() == true) {
					pnlCrtanje.listaOblika.get(i).setSelektovan(false);
					j = 0;
				}
			}
		}
	}

}
