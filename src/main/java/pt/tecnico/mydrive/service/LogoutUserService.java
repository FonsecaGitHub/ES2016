package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

import pt.tecnico.mydrive.domain.*;


public class LogoutUserService extends MyDriveService{

	public LogoutUserService(long token) {
		super.userToken = token;
	}

	@Override
	protected void dispatch() throws MyDriveException {
		getMyDrive().getUserByToken(userToken).endSession();
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