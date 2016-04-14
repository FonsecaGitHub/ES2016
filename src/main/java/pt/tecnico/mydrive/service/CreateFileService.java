package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

//import pt.tecnico.mydrive.exception.*;
//import pt.tecnico.mydrive.domain.*;


public class CreateFileService extends MyDriveService{
	
	private int id;
	private String name;
	private String type;
	private String content;

	public CreateFileService(long userToken, String name, String type, String content) {
		this.userToken = userToken;
		this.name = name;
		this.type = type;
		this.content = content;

		switch (type) {
			case "PlainFile":  ;//todo
				break;
			case "Link":  ;//todo
				break;
			case "Directory":  ;//todo
				break;
			case "Application":  ;//todo
				break;
			default:  ;//todo
				break;
		}
	}


	public CreateFileService(long userToken, String name, String type) {
		this(userToken, name, type, null);
		
	}
	
	@Override
	protected void dispatch() throws MyDriveException {
		// TODO Auto-generated method stub
		
	}
	
	
}