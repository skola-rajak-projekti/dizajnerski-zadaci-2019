package controller.lineCommands;

import model.Linija;
import model.Oblik;
import view.DlgModifikujLiniju;
import view.FrmCrtanje;
import view.PnlCrtez;

public class LineController {
	
	public static void modifySelectedLine(PnlCrtez pnlCrtanje, Oblik oblik, int i) {
		DlgModifikujLiniju modifikujLiniju = new DlgModifikujLiniju();

		modifikujLiniju.getTxtXkoorPocetna().setText(((Linija) oblik).getPocetna().getX() + "");
		modifikujLiniju.getTxtYkoorPocetna().setText(((Linija) oblik).getPocetna().getY() + "");
		modifikujLiniju.getTxtXkoorKrajnja().setText(((Linija) oblik).getKrajnja().getX() + "");
		modifikujLiniju.getTxtYkoorKrajnja().setText(((Linija) oblik).getKrajnja().getY() + "");
		modifikujLiniju.getBtnBojaIvice().setBackground(oblik.getBoja());
		modifikujLiniju.setVisible(true);
		if (modifikujLiniju.tempOdustani == false) {
			
			FrmCrtanje.addCommandToStack(new ModifyLineCommand((Linija)oblik, modifikujLiniju.linija));
		} else if (modifikujLiniju.tempOdustani == true) {
			for (int j = pnlCrtanje.listaOblika.size() - 1; j >= 0; j--) {
				if (pnlCrtanje.listaOblika.get(i).isSelektovan() == true) {
					pnlCrtanje.listaOblika.get(i).setSelektovan(false);
					j = 0;
				}
			}
		}
	}

}
