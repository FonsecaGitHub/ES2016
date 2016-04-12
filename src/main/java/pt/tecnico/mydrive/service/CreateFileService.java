package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

//import pt.tecnico.mydrive.exception.*;
//import pt.tecnico.mydrive.domain.*;


public class CreateFileService extends MyDriveService{
	
	private int id;
	private String name;
	private String type;

	public CreateFileService(long userToken, String name, String type, String content) {
		this.userToken = userToken;
		this.name = name;
		this.type = type;
	}
	public CreateFileService(long userToken, String name, String type) {
		this.userToken = userToken;
		this.name = name;
		this.type = type;
		
	}
	
	@Override
	protected void dispatch() throws MyDriveException {
		// TODO Auto-generated method stub
		
	}
	
	
}