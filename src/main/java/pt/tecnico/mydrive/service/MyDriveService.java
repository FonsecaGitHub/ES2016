package pt.tecnico.mydrive.service;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;
import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public abstract class MyDriveService {
	
	protected String token; 

	@Atomic
	public final void execute() throws MyDriveException {
		
		
		dispatch();
	}

	static MyDrive getMyDrive() {
		return FenixFramework.getDomainRoot().getMydrive();
	}
	
	static User getUser(String token) throws UserDoesNotExistException {
        User u = getMyDrive().getUserByUsername(token);

        if (u == null)
            throw new UserDoesNotExistException(token);

        return u;
    }

	protected abstract void dispatch() throws MyDriveException;

	
}


