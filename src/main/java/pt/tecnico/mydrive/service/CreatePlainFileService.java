package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

//import pt.tecnico.mydrive.exception.*;
//import pt.tecnico.mydrive.domain.*;


public class CreatePlainFileService extends MyDriveService{
	private int id;
	private long userToken;
	private String fileName;
	private String fileContent;

	public CreatePlainFileService(long token, String name, String content) {
		userToken = token;
		fileName = name;
		fileContent = content;
	}
	
	//VASCONCELOS EXCEPCOES...
	@Override
	protected void dispatch() throws MyDriveException, UserIsNotInSessionException {
		MyDrive md = MyDrive.getInstance();
		User user = md.getSession().getUserFromToken(userToken);
		if(user == null || !md.getSession().inSession(user)) {
			throw new UserIsNotInSessionException(user.getMyToken());
		}
		PlainFile plainFile = new PlainFile(md, fileName, fileContent);
	}
	
	
}