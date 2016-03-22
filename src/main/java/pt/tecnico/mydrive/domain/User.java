package pt.tecnico.mydrive.domain;

import org.jdom2.Element;
import java.io.UnsupportedEncodingException;
import org.jdom2.DataConversionException;

import pt.tecnico.mydrive.exception.*;


public class User extends User_Base {
	
	public User() {
		super();
	}
    
    public User(String username, String name) throws InvalidUsernameException {
        super();
        if (username.length() < 3 || !isAlphaNumeric(username)) {
        	throw new InvalidUsernameException(username);
        }
        setUsername(username);
        setName(name);
    }
    
    /*
    public User(MyDrive md, Element xml) {
    	super();
    	xmlImport(xml);
    	setMydrive(md);
    }*/
    
    @Override
    public void setMydrive(MyDrive md) {
        if (md == null)
            super.setMydrive(null);
        else
            md.addUser(this);
    }
    
    public boolean isAlphaNumeric(String s){
        String pattern= "^[a-zA-Z0-9]*$";
            if(s.matches(pattern)){
                return true;
            }
            return false;   
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
    
    //REMOVER O ANTERIOR
    public void delete() {
		setMydrive(null);
		if (isInSession()) {
			getSession().delete();
		}
		for (Permission permission : getPermissionSet()) {
			permission.getFile().delete();
		}
		deleteDomainObject();
	}
    
    public String createSession() {
		if (getSession() != null) {
			getSession().reloadToken();
		} else {
			new Session(this);
		}
		return getSession().getToken();
	}
    
    public void endSession() {
		getSession().delete();
	}
    
    public String getToken() {
		if (getSession() != null) {
			return getSession().getToken();
		}
		return null;
	}
    
    public Boolean isInSession() {
		if (getSession() != null) {
			return true;
		} else
			return false;
	}
}
