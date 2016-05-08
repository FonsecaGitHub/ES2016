package pt.tecnico.mydrive.presentation;

public class Execute extends MdCommand {

	//TODO
    public Execute(Shell sh) {
    	super(sh, "execute", "execute comment");
    }
    
    /**
     * Executa o ficheiro indicado no _path_, 
     * com os argumentos _args_
     * 
     * do path [args]
     */
    public void execute(String[] args) {
	
    //TODO verificar se isto esta certo
     MdShell shell = new MdShell();
     long token = shell.getUserToken();
     shell = null;
     
     if(args.length < 2)
      throw new RuntimeException("USAGE: "+name()+" <path> <args>");
     new ExecuteFile(token,args[0], args[1]).execute();
        
    }
}
