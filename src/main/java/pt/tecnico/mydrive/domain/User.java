package pt.tecnico.mydrive.domain;

import org.jdom2.Element;
import java.io.UnsupportedEncodingException;
import org.jdom2.DataConversionException;

import pt.tecnico.mydrive.exception.UsernameAlreadyExistsException;
import pt.tecnico.mydrive.exception.UsernameCannotBeNullException;
import pt.tecnico.mydrive.exception.WrongPasswordException;
import pt.tecnico.mydrive.exception.ImportDocumentException;
import pt.tecnico.mydrive.exception.UserDoesNotExistException;
import pt.tecnico.mydrive.exception.FileNameAlreadyExistsException;
import pt.tecnico.mydrive.exception.UsernameCannotBeNullException;


public class User extends User_Base {
	
	public User() {
		super();
	}
    
	//ATENCAO ver se aqui deve lancar excepcao
    public User(String username, String name) {
        super();
        setUsername(username);
        setName(name);
    }
    
    public User(MyDrive md, Element xml) {
    	super();
    	xmlImport(xml);
    	setMydrive(md);
    }
    
    @Override
    public void setMydrive(MyDrive md) {
        if (md == null)
            super.setMydrive(null);
        else
            md.addUser(this);
    }
    
    @Override
    public void addFile(File fileToBeAdded) throws FileNameAlreadyExistsException {
        if (hasFile(fileToBeAdded.getName()))
            throw new FileNameAlreadyExistsException(fileToBeAdded.getName());

        super.addFile(fileToBeAdded);
    }
    
    //ATENCAO aqui talvez seja por ID em vez de ser por nome
    public File getFileByName(String name) {
        for (File file: getFileSet())
            if (file.getName().equals(name))
                return file;
        return null;
    }
    
    public boolean hasFile(String fileName) {
        return getFileByName(fileName) != null;
    }

    
    //ATENCAO ver se e preciso eliminar os ficheiros antes de eliminar o User
    public void remove() {
    	/*for (Permission permission : getPermissionSet()) {
			permission.remove();
		}*/
		setMydrive(null);
		deleteDomainObject();
	}

	//TODO
	public Element xmlImport(Element userElement) throws ImportDocumentException {
		// clear current mydrive
		//for (File f: getFileSet())
			
			//f.remove();
		
		//ATENCAO apagar linha seguinte
		return userElement;
	}

	//TODO
	public void xmlExport() {

	}
    
}
