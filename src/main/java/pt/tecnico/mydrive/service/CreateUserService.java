package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class CreateUserService extends MyDriveService{

	private String newUser;
	private String name;

	public CreateUserService(long userToken, String newUsername, String name) {
		this.userToken = userToken;
		this.newUser = newUsername;
		this.name = name;
		
	}

	@Override
	protected void dispatch() throws UsernameAlreadyExistsException {
		new User(getMyDrive(), newUser, name);
	}

}