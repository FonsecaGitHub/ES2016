package pt.tecnico.mydrive.service;

import java.util.ArrayList;
import java.util.List;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class ListDirectoryService extends MyDriveService{
	
	List<String> result;
	
	public ListDirectoryService(long token) {
		super.userToken = token;
		result = new ArrayList<>();
	}
	
	public List<String> getResult(){
		return result;
	}
	
	@Override
	protected void dispatch() throws MyDriveException {
		MyDrive md = MyDrive.getInstance();
		User u = md.getUserByToken(userToken);
		Session s = u.getSession();
		Directory d = s.getWorkDir();
		if(u.isInSession()){
			this.result = d.listAllFiles();
		}
		
	}
}