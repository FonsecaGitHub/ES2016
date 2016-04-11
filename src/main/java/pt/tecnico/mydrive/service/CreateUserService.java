package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class CreateUserService extends MyDriveService{

	private long _userToken;	
	private String _newUser;
	private String _name;
	private String _password;

	public CreateUserService(long userToken, String newUsername, String name, String password) {
		_userToken = userToken;
		_newUser = newUsername;
		_name = name;
		_password = password;
	}

	@Override
	protected void dispatch() throws MyDriveException {
		MyDrive mydrive = MyDrive.getInstance();
		
		mydrive.addUser(new User(mydrive, _newUser, _name, _password));
	}
}