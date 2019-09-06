package controller.squareCommands;

import controller.Command;
import model.KvadratG;
import view.PnlCrtez;

public class ModifySquareCommand implements Command {
	
	private KvadratG oldState;
	private KvadratG newState;
	
	public ModifySquareCommand(KvadratG oldState, KvadratG newState) {
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
