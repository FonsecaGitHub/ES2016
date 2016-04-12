package pt.tecnico.mydrive.domain;

import org.jdom2.Element;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.jdom2.DataConversionException;

import java.io.File;

public class Directory extends Directory_Base {
   
	
	public Directory() {
		super();
	}
    
    public Directory(String path, String name)/* throws PathTooLongException */{
    	super();
    	String pathString = path.toString();
    	//VASCONCELOS ADDICIONA EXCEPCAO
    	if (pathString.length() > 1024) {
    		//throw new PathTooLongException(path);
    	}
    	setPath(path);
    	setName(name);
    }
    
    /*public Directory(User user, Element xml) {
    	super();
    	//xmlImport();
    	setUser(user);
    }*/
    
    /*@Override
    public void setUser(User user) {
        if (user == null)
            super.setUser(null);
        else
            user.addDirectory(this);
    }*/
    
    
    public void remove(){
    	deleteDomainObject();
    }

   

    public void createDir(String dirPath) {
        //TODO
    }
    
    public String getPath(){
    	return getDir().getPath() + "/" + getName();
    }
}
