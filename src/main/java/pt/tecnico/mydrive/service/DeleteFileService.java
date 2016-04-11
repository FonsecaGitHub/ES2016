package pt.tecnico.mydrive.service;

//import pt.tecnico.mydrive.exception.*;
//import pt.tecnico.mydrive.domain.*;


import pt.tecnico.mydrive.exception.FileDoesNotExistException;
import pt.tecnico.mydrive.exception.MyDriveException;

public class DeleteFileService extends MyDriveService{

	//private String filename;
	//private long token
	
	public DeleteFileService(Long token, String filename) {
		//this.token = getMyDrive().getUserByToken(token);
		//this.filename = filename;
	}
	
	@Override
	protected void dispatch() throws MyDriveException, FileDoesNotExistException {
		// TODO Auto-generated method stub
		
		//missing way to get userfiles from token
		/*for {User u : directory.getdirectorySet(token)
			if (u.hasDirectory(filename))
				for {Directory d : directory.getdownedSet(token)
					user.RemoveFilesFromDirectory(d);
					user.RemoveDirectory(filename);
				}
		}
		File f = getFileByName(filename);
		for {User u : file.getFileSet(token)
			if (u.hasfile(f) == null)
			throw new FileDoesNotExist(filename);
		user.RemoveFile(f);
		}	*/	
		
	}
		
}
	