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
   public void dispatch() throws DirectoryDoesNotExistException {
	 	
	 Directory _dir = _token.getCurrentDirectory();   
	 if(_token.isValid() == true){
   		_token.dateReset();
   		if(_dir.fileExists( _dir.getFileByPath(_path).getId())== true){
   			if(_path.equals(".")){
   				_newPath=_dir.getPath() + _dir.getName();
   			}
   			else{
   				Directory newDir =(Directory) _dir.getFileByPath(_path);
   				_token.setCurrentDirectory(newDir);
   				_newPath=newDir.getPath() + "/" + newDir.getName();
   			}
   		}
   		else{
   			throw new DirectoryDoesNotExistException(_path);
   		}
	}
		
  }
   public String changeDir(){
	  
	   return _newPath;
   }
   
}
