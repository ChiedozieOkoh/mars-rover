package com.rover;

public class CommandListExecutor{
	private Command[] commands; 
	public CommandListExecutor(String str) throws UnkownCommandException{
		commands = makeCommandArray(str);
	}
	
	public void run(Rover rover){
		for (Command command : commands) {
				command.execute(rover);
		}	
	}

	private  Command[] makeCommandArray(String arguements) throws UnkownCommandException{
		Command[] actions = new Command[arguements.length()];
		for(int i = 0; i < arguements.length(); i++){
			actions[i] = CommandGenerator.generateCommand(String.valueOf(arguements.charAt(i)));
		}
		return actions; 
	}
}