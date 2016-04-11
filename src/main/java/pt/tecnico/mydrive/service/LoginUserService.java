package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

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
		MyDrive md = MyDrive.getInstance();
		Session session = md.getSession();
		session.removeInactives();
		
		MyToken mt = session.createSession(_username, _password);
		String tokenString = Long.toString(mt.getToken());
		_username = tokenString;
	}

	public final long getUserToken() {
		return _token;
	}
}