package pt.tecnico.mydrive.presentation;

import pt.tecnico.mydrive.service.WriteFileService;

public class Write extends MdCommand {

	//TODO
    public Write(Shell sh) {
    	super(sh, "list", "list persons (or person contacts, given person name");
    }
    
    /**
     * Altera o conteudo de um ficheiro.
     * 
     * update path text
     */
    public void execute(String[] args) {

    //TODO verificar se isto esta certo
     MdShell shell = new MdShell();
     long token = shell.getUserToken();
     shell = null;
     
     if(args.length < 2)
      throw new RuntimeException("USAGE: "+name()+" <path> <content>");
     new WriteFileService(token,args[0], args[1]).execute();
    	
    }
}
