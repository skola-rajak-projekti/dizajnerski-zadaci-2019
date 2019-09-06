package controller.circleCommands;

import controller.Command;
import model.Circle;
import view.PnlCrtez;

public class ModifyCircleCommand implements Command {

	private Circle oldState;
	private Circle newState;
	
	public ModifyCircleCommand(Circle oldState, Circle newState) {
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
