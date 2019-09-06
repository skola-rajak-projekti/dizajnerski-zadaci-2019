package controller.circleCommands;

import controller.Command;
import model.Circle;
import view.PnlCrtez;

public class AddNewCircleCommand implements Command {

	private Circle circle;
	
	public AddNewCircleCommand(Circle newCircle) {
		circle = newCircle;
	}
	
	@Override
	public void execute() {
		
		PnlCrtez.getListaOblika().add(circle);		
	}

	@Override
	public void undo() {
		
		PnlCrtez.getListaOblika().remove(circle);
		
	}
	

}
