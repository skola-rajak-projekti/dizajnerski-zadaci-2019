package controller.squareCommands;

import controller.Command;
import model.KvadratG;
import view.PnlCrtez;

public class AddNewSquareCommand implements Command {
	private KvadratG square;
	
	public AddNewSquareCommand(KvadratG newSquare) {
		square = newSquare;
	}
	
	@Override
	public void execute() {
		PnlCrtez.getListaOblika().add(square);
	}
	
	@Override
	public void undo() {
		PnlCrtez.getListaOblika().remove(square);
	}
}