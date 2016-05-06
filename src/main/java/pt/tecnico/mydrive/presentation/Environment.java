package pt.tecnico.mydrive.presentation;

public class Environment extends MdCommand {
	
	//TODO
    public Environment(Shell sh) {
    	super(sh, "list", "list persons (or person contacts, given person name");
    }
    
    /**
     * Cria ou altera a variavel de ambiente.
     * 
     * env [name [value]]
     */
    public void execute(String[] args) {
	//TODO
    }
}
