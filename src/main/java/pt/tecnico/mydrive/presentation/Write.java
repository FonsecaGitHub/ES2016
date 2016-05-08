package pt.tecnico.mydrive.presentation;

import pt.tecnico.mydrive.domain.MyDrive;
import pt.tecnico.mydrive.presentation.MdShell;
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
    	
    }
}
