package controller;

import java.util.LinkedList;

public class CommandStack {
	
	public static LinkedList<Command> commandStack = new LinkedList<Command>();

	public void execute(Command command) {
		
		command.execute();
		commandStack.addFirst(command);
	}

	public void undo() {
		if (commandStack.isEmpty()) {
			System.out.println(" prazan stack ");
			return;
		}
		Command command = commandStack.removeFirst();
		command.undo();
	}
}
