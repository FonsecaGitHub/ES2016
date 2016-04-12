package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

//import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class ListDirectoryService extends MyDriveService{

	
	public ListDirectoryService(long token) {
		super.userToken = token;
	}
	
	@Override
	protected void dispatch() throws MyDriveException {
		// TODO Auto-generated method stub
		MyDrive md = super.getMyDrive();
		//md.listFiles(path); TODO
		
	}
}