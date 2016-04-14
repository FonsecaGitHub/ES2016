package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

import pt.tecnico.mydrive.domain.*;


public class LoginUserService extends MyDriveService{
	
	private long token;
	private String username;
	private String password;

	public LoginUserService(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	protected void dispatch() throws MyDriveException {	
		MyDrive md = MyDrive.getInstance();
		Session session = md.getSession();
		session.removeInactives();
		
		MyToken mt = session.createSession(this.username, this.password);
		String tokenString = Long.toString(mt.getToken());
		this.username = tokenString;
		//TU nem sequer mexes no token. a ultima linha que te deixei embaixo cria te um token para a sessao
		// para que servem estas duas? 
		//String tokenString = Long.toString(mt.getToken());
		//this.username = tokenString;
		
		
		//this.token = session.createToken();
	}

	public final long getToken() {
		return token;
	}

	//todo ver se isto pertence aqui ou nao
	public User getUserByToken(long token) {
		//todo implement and fix
		return this.getUserByToken(token);
	}
}