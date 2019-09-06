package controller.rectangleCommands;

import controller.Command;
import model.Pravougaonik;
import view.PnlCrtez;

public class AddNewRectangleCommand implements Command {
	private Pravougaonik rectangle;
	
	public AddNewRectangleCommand(Pravougaonik newRectangle) {
		rectangle = newRectangle;
	}
	
	@Override
	public void execute() {
		PnlCrtez.getListaOblika().add(rectangle);
	}
	
	@Override
	public void undo() {
		PnlCrtez.getListaOblika().remove(rectangle);
	}
}