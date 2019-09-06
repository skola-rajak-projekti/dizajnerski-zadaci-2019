package controller.pointCommands;

import controller.Command;
import model.Tacka;
import view.PnlCrtez;

public class AddNewPointCommand implements Command {

	private Tacka point;
	
	public AddNewPointCommand(Tacka newPoint) {
		point = newPoint;
	}
	
	@Override
	public void execute() {

		
		PnlCrtez.getListaOblika().add(point);		
	}

	@Override
	public void undo() {
		
		PnlCrtez.getListaOblika().remove(point);
	
	}
}
	
