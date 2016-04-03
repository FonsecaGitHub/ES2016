package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class LoginUserService extends MyDriveService{
	private String username;
	private String password;

	public LoginUserService(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	protected void dispatch() throws MyDriveException {
		super.userToken = getMyDrive().loginUser(this.username, this.password);
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