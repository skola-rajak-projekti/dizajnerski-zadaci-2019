package controller.lineCommands;

import controller.Command;
import model.Linija;
import view.PnlCrtez;

public class ModifyLineCommand implements Command {
	
	private Linija oldState;
	private Linija newState;
	
	public ModifyLineCommand(Linija oldState, Linija newState) {
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
