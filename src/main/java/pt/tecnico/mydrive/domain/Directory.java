package pt.tecnico.mydrive.domain;

import org.jdom2.Element;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.jdom2.DataConversionException;

import java.io.File;

public class Directory extends Directory_Base {
    
	//private String local;
	
	public Directory() {
		super();
	}
    
    public Directory(String name) {
    	super();
    	//setUser(username);
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
    
    public void createDir(String local) {
    	File dir = new File(local);
    	
    	boolean successful = dir.mkdirs();
    	//dir.mkdirs();
    	
    	
    	 if (successful)
        {
          // created the directories successfully
          System.out.println("directories were created successfully");
        }
        else
        {
          // something failed trying to create the directories
          System.out.println("failed trying to create the directories");
        }
        
    }
    
    public void remove(){
    	deleteDomainObject();
    	
    }

    public void listFiles(String path) {
        File[] files = new File(path).listFiles();
        
        for(File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
    

    /*
    public File getFiles(){
        if(this.equals(null))
            return null;
        //TO DO acabar a função get file
    }
        
        
    public ArrayList<File> listFilesInDirectory(String path){
        ArrayList <File> files = new ArrayList<File>(); 
        String[] p = path.split("/");
        String lastDir = p[p.length-1];
        MyDrive md = null;
        Directory d = md.getInstance().getDirectoryByName(lastDir);
        files.add(d.getFiles());
        return files;
    }*/
    
    
    
    
    
}
