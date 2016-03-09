package pt.tecnico.mydrive.domain;



import pt.tecnico.mydrive.domain.Permission;
import pt.tecnico.mydrive.domain.File;
import pt.tecnico.mydrive.exception.InvalidUsernameException;
import pt.tecnico.mydrive.exception.SpreadSheetDoesNotExistException;
import pt.tecnico.mydrive.exception.UserDoesNotHaveAccessException;

import org.jdom2.DataConversionException;
import org.jdom2.Element;

public class User extends User_Base {
	
	public User() {
		super();
	}

	/*public User(String username, String name) throws InvalidUsernameException {
		super();
		if (username.length() < 1) {
			throw new InvalidUsernameException(username);
		}
		setUsername(username);
		setName(name);
	}

	public void delete() {
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