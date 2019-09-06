package controller.circleCommands;

import model.Circle;
import model.Oblik;
import view.DlgModifikujKrug;
import view.FrmCrtanje;
import view.PnlCrtez;

public class CircleController {

	public static void modifySelectedCircle(PnlCrtez pnlCrtanje, Oblik oblik, int i) {

		DlgModifikujKrug modifikujKrug = new DlgModifikujKrug();

		modifikujKrug.getTxtXkoordinata().setText(((Circle) oblik).getCentar().getX() + "");
		modifikujKrug.getTxtYkoordinata().setText(((Circle) oblik).getCentar().getY() + "");
		modifikujKrug.getTxtPoluprecnik().setText(((Circle) oblik).getPoluprecnik() + "");
		modifikujKrug.getBtnBojaIvice().setBackground(oblik.getBoja());
		modifikujKrug.getBtnBojaUnutrasnjosti()
				.setBackground(((Circle) oblik).getBojaUnutrasnjosti());
		modifikujKrug.setVisible(true);

		if (modifikujKrug.tempOdustani == false) {
			
			FrmCrtanje.addCommandToStack(new ModifyCircleCommand((Circle)oblik , modifikujKrug.krug));
			
			
			
			
		} else if (modifikujKrug.tempOdustani == true) {
			for (int j = pnlCrtanje.listaOblika.size() - 1; j >= 0; j--) {
				if (pnlCrtanje.listaOblika.get(i).isSelektovan() == true) {
					pnlCrtanje.listaOblika.get(i).setSelektovan(false);
					j = 0;
				}
			}
		}
	}

}
