package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.*;


public class CreateUserService extends MyDriveService{

	private String newUser;
	private String name;

	public CreateUserService(String userToken, String newUsername, String name) {
		this.userToken = userToken;
		this.newUser = newUsername;
		this.name = name;
		
	}

	@Override
	protected void dispatch() throws MyDriveException {
		checkUserIsRoot(userToken);
		getMyDrive().addUser(newUser);
	}

}