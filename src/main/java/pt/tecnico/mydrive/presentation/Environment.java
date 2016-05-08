package pt.tecnico.mydrive.presentation;

import pt.tecnico.mydrive.service.AddVariableService;

public class Environment extends MdCommand {
	
	//TODO
    public Environment(Shell sh) {
    	super(sh, "enviromnent", "enviromnent comment");
    }
    
    /**
     * Cria ou altera a variavel de ambiente.
     * 
     * env [name [value]]
     */
    public void execute(String[] args) {

    //TODO verificar se isto esta certo
     MdShell shell = new MdShell();
     long token = shell.getUserToken();
     shell = null;
     
     if(args.length < 2)
      throw new RuntimeException("USAGE: "+name()+" <name> <value>");
     new AddVariableService(token,args[0], args[1]).execute();
        
    }
}
