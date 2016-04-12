package pt.tecnico.mydrive.service;


import pt.tecnico.mydrive.domain.*;

import pt.tecnico.mydrive.exception.*;

public class ChangeDirectoryService extends MyDriveService{
   
   private MyToken _token;
   private String _path;
   private String _newPath;
   
   public ChangeDirectoryService(MyToken token, String path){
    		_token = token;
    		_path = path;
    }
   
   @Override 
   public void dispatch() throws UnauthorizedAccessException , DirectoryDoesNotExistException {
/*	 	
	Directory _dir = _token.getCurrentDirectory();   
	if(_token.validate() == true){
   		_token.newTime();
   		if(_dir.fileExists( _dir.getFileByPath(_path).getId())== true){
   			if(_path.equals(".")){
   				_newPath=_dir.getPath() + _dir.getName();
   			}
   			else{
   				Directory newDir =(Directory) _dir.getFileByPath(_path).getId();
   				_token.setCurrDir(newDir);
   				_newPath=newDir.get_path() + "/" + newDir.get_name();
   			}
   		}
   		else{
   			throw new DirectoryUnknownException( _path);
   		}
	}
   	else{
   		throw new UnauthorizedAccessException(_token.getUser1().get_name());
   	}
		
   }
   public String cd(){
	  
	   return _newPath;
   }
   
}*/
}