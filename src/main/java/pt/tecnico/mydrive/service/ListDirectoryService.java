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
		MyDrive md = MyDrive.getInstance();
		User u = md.getUserByToken(userToken);
		Session s = u.getSession();
		Directory d = s.getWorkDir();
		if(u.isInSession()){
			d.listAllFiles();
		}
	}
}