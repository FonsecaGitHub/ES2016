package pt.tecnico.mydrive.domain;

import org.jdom2.Element;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.DataConversionException;



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
    
    
    //Corrigir isto: verificar se estou a por dir ou files
    
    public void listAllFiles() {
    	for(File f: getOwnedSet()){
    		System.out.print(f.getType());
    		//System.out.print(f.getPermissions());
    		//System.out.print(f.getContent());
    		System.out.print(f.getOwner().getUsername());
    		System.out.print(f.getId());
    		System.out.print(f.getDatamod());
    		System.out.println(f.getName());
    	}
	}

    public boolean fileExists(int id){
        MyDrive md = MyDrive.getInstance();
        pt.tecnico.mydrive.domain.File file = md.getFile(id);
        return (file != null);
    }

    public pt.tecnico.mydrive.domain.File getFileByPath(String path) {
        for(pt.tecnico.mydrive.domain.File file : getOwnedSet()){
            if(file.getPath().equals(path))
                return file;
        }
        return null;
    }
    

    
    @Override
    public String getType(){
    	return "Directory";
    }
}
