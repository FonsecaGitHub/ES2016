package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.MyDriveException;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class ReadFileService extends MyDriveService{

	private String name;
	private String cont;
	
	public ReadFileService(long userToken, String name){
	this.userToken = userToken;
	this.name = name;
	
	}
	
	@Override
	protected void dispatch() throws MyDriveException {
		MyDrive md = MyDrive.getInstance();
		PlainFile pf = md.getPlainFileByName(name);
		cont = pf.getContent();
	}
	public final String getCont(){
		return cont; 
	}
	
}