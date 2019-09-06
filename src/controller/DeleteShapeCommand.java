package controller;

import model.Oblik;
import view.PnlCrtez;

public class DeleteShapeCommand implements Command {

	private Oblik target;
	
	public DeleteShapeCommand(Oblik oblik)
	{
		this.target = oblik;
	}
	@Override
	public void execute() {
		
		PnlCrtez.listaOblika.remove(target);

	}

	@Override
	public void undo() {
		
		PnlCrtez.listaOblika.add(target);
	}

}
