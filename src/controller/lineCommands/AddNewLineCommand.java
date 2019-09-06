package controller.lineCommands;

import controller.Command;
import model.Linija;
import view.PnlCrtez;

public class AddNewLineCommand implements Command {

	private Linija line;
	
	public AddNewLineCommand(Linija newLine) {
		line = newLine;
	}
	
	@Override
	public void execute() {
		PnlCrtez.getListaOblika().add(line);
		
	}

	@Override
	public void undo() {
		PnlCrtez.getListaOblika().remove(line);

	}

}
