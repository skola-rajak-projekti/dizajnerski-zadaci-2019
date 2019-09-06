package controller.rectangleCommands;

import controller.Command;
import model.Pravougaonik;
import view.PnlCrtez;

public class ModifyRectangleCommand implements Command {
	
	private Pravougaonik oldState;
	private Pravougaonik newState;
	
	public ModifyRectangleCommand(Pravougaonik oldState, Pravougaonik newState) {
		this.oldState = oldState;
		this.newState = newState;
	}
	
	@Override
	public void execute() {
		PnlCrtez.listaOblika.remove(oldState);
		PnlCrtez.listaOblika.add(newState);
	}
	
	@Override
	public void undo() {
		PnlCrtez.listaOblika.remove(newState);
		PnlCrtez.listaOblika.add(oldState);
	}
}
