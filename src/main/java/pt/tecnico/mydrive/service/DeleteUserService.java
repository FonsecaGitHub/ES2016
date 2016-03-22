package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class DeleteUserService extends MyDriveService{

	private String username;

	public DeleteUserService(String userToken, String usernameToDelete) {
		super.userToken = userToken;
		this.username = usernameToDelete;
	}

	@Override
	protected void dispatch() throws MyDriveException {
		checkUserIsRoot(userToken);
		
		getMyDrive().removeUser(username);
	}
}