package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class ExecuteFile extends MyDriveService{

	private long userToken;	
	private String path;
	private String[] args;

	public ExecuteFile(long userToken, String path, String[] args) {
		this.userToken = userToken;
		this.path = path;
		this.args = args;
		
	}

	
	@Override
	protected void dispatch() throws MyDriveException {
	
	}
}