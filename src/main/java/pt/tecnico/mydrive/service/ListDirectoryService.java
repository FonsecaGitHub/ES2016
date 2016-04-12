package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

import java.util.ArrayList;
import java.util.List;

//import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class ListDirectoryService extends MyDriveService{
	
	private List<File> files = new ArrayList<File>();
	
	public ListDirectoryService(long token) {
		super.userToken = token;
	}
	
	@Override
	protected void dispatch() throws MyDriveException {
		// TODO Auto-generated method stub
		MyDrive md = getMyDrive();/*
		User u = getUserFromToken(userToken);
		Directory d = u.getHomeDirectory();
		if(u.isInSession()){
			md.listFiles(d.getPath());
		}	*/
	}
}