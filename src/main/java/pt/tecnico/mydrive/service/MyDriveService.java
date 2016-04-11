package pt.tecnico.mydrive.service;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;
import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public abstract class MyDriveService {
	
	protected long userToken; 

	@Atomic
	public final void execute() throws MyDriveException {
		dispatch();
	}

	static MyDrive getMyDrive() {
		return FenixFramework.getDomainRoot().getMydrive();
	}

	protected abstract void dispatch() throws MyDriveException;

	/*
	protected void sessionIsValid(String token) {
		User user = getMyDrive().getUserByToken(token);
		if(user == null) {
			throw new UserIsNotInSessionException(userToken);
		}
	}*/
	
	/*
	protected void checkUserIsRoot(String token) {
		User user = getMyDrive().getMyDriveByToken(token);
		if(!user.getUsername().equals("root")) {
			throw new UnauthorizedOperationException();
		}
	}*/

	/*
	protected void updateUserSession(String token) {
		getMyDrive().updateUserLastAccess(token);
	}*/

	static User getUser(String token) throws UserDoesNotExistException {
        User u = getMyDrive().getUserByUsername(token);
        if (u == null)
            throw new UserDoesNotExistException(token);
        return u;
    }
	
	
	
}


