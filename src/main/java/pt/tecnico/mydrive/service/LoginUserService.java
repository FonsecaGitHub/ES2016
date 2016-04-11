package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class LoginUserService extends MyDriveService{
	
	private long _token;
	private String _username;
	private String _password;

	public LoginUserService(String username, String password) {
		_username = username;
		_password = password;
	}

	@Override
	protected void dispatch() throws MyDriveException {
		/*super.userToken = getMyDrive().loginUser(this.username, this.password);*/
		MyDrive md = MyDrive.getInstance();
		Session session = md.getSession();
		
	}

	public final long getUserToken() {
		return super.userToken;
	}
	/*
	@Override
	protected void sessionIsValid(String token) {
		//override to blank
	}

	@Override
	protected void updateUserSession(String token) {
		//override to blank
	}*/
}