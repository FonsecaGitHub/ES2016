package pt.tecnico.MyDrive.service;


import pt.tecnico.MyDrive.domain.Directory;
import pt.tecnico.MyDrive.domain.MyToken;

import pt.tecnico.MyDrive.exception.UnauthorizedAccessException;
import pt.tecnico.MyDrive.exception.DirectoryDoesNotExistsException;

public class ChangeDirectoryService extends MyDriveService{
   
   private Token _token;
   private String _path;
   private String _newPath;
   
   public ChangeDirectoryService(Token token, String path){
    		_token= token;
    		_path= path;
    }
   
   @Override 
   public void dispatch() throws UnauthorizedAccessException , DirectoryDoesNotExistsException {
	
  /*
	Directory _dir = _token.getCurrDir();   
	if(_token.validate() == true){
   		_token.newTime();
   		if(_dir.fileExists( _dir.getFilebyPath(_path))== true){
   			if(_path.equals(".")){
   				_newPath=_dir.get_path() + _dir.get_name();
   			}
   			else{
   				Directory newDir =(Directory) _dir.getFilebyPath(_path);
   				_token.setCurrDir(newDir);
   				_newPath=newDir.get_path() + "/" + newDir.get_name();
   			}
   		}
   		else{
   			throw new DirectoryUnknownException( _path);
   		}
	}
   	else{
   		throw new AccessDeniedException(_token.getUser1().get_name());
   	}
		
   }
   public String cd(){
	  
	   return _newPath;
   }
   */
}