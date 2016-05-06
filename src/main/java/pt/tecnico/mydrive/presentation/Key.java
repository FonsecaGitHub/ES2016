package pt.tecnico.mydrive.presentation;

public class Key extends MdCommand {

	//TODO
    public Key(Shell sh) {
    	super(sh, "token", "Prints token and current user if no user provided, or changes the current user with the username provided.");
    }
    
    /**
     * Imprime o valor do token e username do utilizador actual,
     * ou altera o utilizador actual e o token activo e imprime 
     * o seu valor quando recebe um argumento username.
     * 
     * token [username]
     */
    public void execute(String[] args) {
    	//TODO
    	//if(args.length < 1)	
    }
}
