package pt.tecnico.mydrive.service;

//import pt.tecnico.mydrive.exception.*;
//import pt.tecnico.mydrive.domain.*;


public class DeleteFileService extends MyDriveService{

	//private String filename;
	
	public DeleteFileService(Long userToken, String filename) {
		//super.userToken = getMyDrive().getUserByToken(usertoken);
		//this.filename = filename;
	}
	
	@Override
	protected void dispatch() throws MyDriveException, FileDoesNotExist {
		// TODO Auto-generated method stub
		
		//missing way to get userfiles from token
		/*for {User u : directory.getdirectorySet(userToken)
			if (u.hasDirectory(filename))
				for {Directory d : directory.getdownedSet(userToken)
					user.RemoveFilesFromDirectory(d);
					user.RemoveDirectory(filename);
				}
		}
		File f = getFileByName(filename);
		for {User u : file.getFileSet(userToken)
			if (u.hasfile(f) == null)
			throw new FileDoesNotExist(filename);
		user.RemoveFile(f);
		}	*/	
		
	}
		
}
	