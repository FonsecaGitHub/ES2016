package pt.tecnico.mydrive.presentation;

import pt.tecnico.mydrive.domain.MyToken;
import pt.tecnico.mydrive.service.ChangeDirectoryService;


public class ChangeWorkingDirectory extends MdCommand {

	//TODO
    public ChangeWorkingDirectory(Shell sh) {
    	super(sh, "changedir", "change working directory");
    }
    
    /**
     * Altera a directoria corrente  e imprime o caminho
     * para a nova directoria corrente _path_
     * 
     * cwd [path]
     */
    public void execute(String[] args) {
    ChangeDirectoryService cwd; 
    MyToken token = ((MdShell) shell()).getMyToken();     
    
    if(args.length < 1)
        throw new RuntimeException("USAGE: "+name()+" <path> ");
       cwd =  new ChangeDirectoryService(token, args[0]);

       //execute
       //imprimir nova directoria
       cwd.execute();
       //System.out.println(
    }
}
