package controller.aligment;

import controller.Command;
import model.Oblik;
import view.PnlCrtez;

public class MoveToFront implements Command {

	private Oblik target;
	
	public MoveToFront(Oblik shape) {
		target = shape;	
	}
	
	@Override
	public void execute() {
		if(target != null)
		{	
			System.out.println(" moved to front ");
			int index = PnlCrtez.listaOblika.indexOf(target);
			PnlCrtez.listaOblika.remove(index);
			PnlCrtez.listaOblika.add(PnlCrtez.listaOblika.size(), target);
			
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
	

}
