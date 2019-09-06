package controller.pointCommands;

import controller.Command;
import model.Tacka;
import view.PnlCrtez;

public class ModifyPointCommand implements Command {

	private Tacka oldState;
	private Tacka newState;
	
	public ModifyPointCommand(Tacka oldState, Tacka newState) {
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
