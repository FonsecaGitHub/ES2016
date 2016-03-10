package pt.tecnico.mydrive.domain;

import org.jdom2.Element;
import java.io.UnsupportedEncodingException;
import org.jdom2.DataConversionException;

import pt.tecnico.mydrive.domain.Permission;
import pt.tecnico.mydrive.domain.File;

import pt.tecnico.mydrive.exception.UsernameAlreadyExistsException;
import pt.tecnico.mydrive.exception.UsernameCannotBeNullException;
import pt.tecnico.mydrive.exception.WrongPasswordException;
import pt.tecnico.mydrive.exception.ImportDocumentException;
import pt.tecnico.mydrive.exception.UserDoesNotExistException;
import pt.tecnico.mydrive.exception.FileNameAlreadyExistsException;


public class User extends User_Base {
    
    public User() {
        super();
        //setName(name);
        //setMydrive(md);
    }

    //definir xmlImport
    /*public User(MyDrive md, Element xml) {
    	super();
    	xmlImport(xml);
    	setMydrive(md);
    }*/
    
   /* @Override
    public void setMydrive(MyDrive pb) {
        if (pb == null)
            super.setMydrive(null);
        else
            pb.addUser(this);
    }*/
    
    /*@Override
    public void addFile(File fileToBeAdded) throws FileNameAlreadyExistsException {
        if (hasFile(fileToBeAdded.getName()))
            throw new UsernameAlreadyExistsException(fileToBeAdded.getName());

        super.addFile(fileToBeAdded);
    }
    
    public File getFileByName(String name) {
        for (File file: getFileSet())
            if (file.getName().equals(name))
                return file;
        return null;
    }
    
    public boolean hasFile(String fileName) {
        return getFileByName(fileName) != null;
    }*/

    //ATENCAO ver se e preciso eliminar os ficheiros antes de eliminar o User
	//public void remove() {
		//setMyDrive(null);
		//adicionar funcao em Permissions
		/*for (Permissions permissions : getPermissionsSet()) {
			permissions.getFile().delete();
		}
		deleteDomainObject();
	}

	//TODO
	public Element exportToXML() {

	}

	//TODO
	public void importFromXML() {

	}*/
    
}
