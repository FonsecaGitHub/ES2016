package pt.tecnico.mydrive.domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import org.jdom2.Element;
import org.jdom2.Document;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.ist.fenixframework.FenixFramework;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.service.CreateXMLFile;
import pt.tecnico.mydrive.service.ReadXMLFile;

public class MyDrive extends MyDrive_Base {
    static final Logger log = LogManager.getRootLogger();

    public static MyDrive getInstance() {
        MyDrive md = FenixFramework.getDomainRoot().getMydrive();
        if (md != null)
	    return md;

	log.trace("new MyDrive");
        return new MyDrive();
    }
    
    private MyDrive() {
        setRoot(FenixFramework.getDomainRoot());
    }
    
    
    public User getUserByUsername(String username) throws UserDoesNotExistException {
        for (User user : getUserSet()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    public boolean hasUser(String username) {
        return getUserByUsername(username) != null;
    }
    
    @Override
    public void addUser(User userToBeAdded) throws UsernameAlreadyExistsException {
        if (hasUser(userToBeAdded.getUsername()))
            throw new UsernameAlreadyExistsException(userToBeAdded.getUsername());

        super.addUser(userToBeAdded);
    }
    
    public void removeUser(String username) {
    	if (username.equals("root")) {
    		//JOAO ADICIONA ESTA EXCEPCAO
    		//throw new UnauthorizedOperationException();
    	} else {
    		User userToRemove = getUserByUsername(username);
    		if (userToRemove == null) {
    			throw new UserDoesNotExistException(username);
    		}
    		//Ainda nao e necessario para esta entrega
    		/*for (Permission permission : userToRemove.getPermissionSet()) {
    			if (permission.getAccess() == Access.OWNS) {
    				File file = permission.getFile();
    				file.remove();
    			}
    		}*/ 
    		userToRemove.remove();
    	}
    }
    
    
    //			HANDLES DIRECTORY
    public Directory getDirectoryByPath(String path) {
        for (Directory directory : getDirectorySet()) {
            if (directory.getPath().equals(path)) {
                return directory;
            }
        }
        return null;
    }
    
    public boolean hasDirectory(String path) {
        return getDirectoryByPath(path) != null;
    }
  
    @Override
    public void addDirectory(Directory directoryToBeAdded) throws DirectoryNameAlreadyExistsException {
    	if (hasDirectory(directoryToBeAdded.getPath()))
    		throw new DirectoryNameAlreadyExistsException(directoryToBeAdded.getPath());
    	
    	super.addDirectory(directoryToBeAdded);
    }
    
    public void removeDirectory(String path) {
    	Directory directoryToRemove = getDirectoryByPath(path);
    	if (directoryToRemove == null) {
    		throw new DirectoryDoesNotExistException(path);
    	}
    	directoryToRemove.remove();
    }
    
    
    //			HANDLES PLAINFILE
    public PlainFile getPlainFileByPath(String path) {	
    	for (PlainFile plainFile : getPlainfileSet()) {
            if (plainFile.getPath().equals(path)) {
                return plainFile;
            }
        }
        return null;
    }
    
    public boolean hasPlainFile(String path) {
        return getPlainFileByPath(path) != null;
    }
    
    //JOAO ARRANJA UMA EXCEPCAO MELHOR
    public void addPlainFile(PlainFile plainFileToBeAdded) throws FileNameAlreadyExistsException {
    	if (hasPlainFile(plainFileToBeAdded.getPath()))
    		throw new FileNameAlreadyExistsException(plainFileToBeAdded.getPath());
    	
    	super.addPlainfile(plainFileToBeAdded);
    }
    
    public void removePlainFile(String path) {
    	PlainFile plainFileToRemove = getPlainFileByPath(path);
    	if (plainFileToRemove == null) {
    		throw new FileDoesNotExistException(path);
    	}
    	plainFileToRemove.remove();
    }
   
	
	public void cleanup() {
		for (Directory d: getDirectorySet())
			d.remove();
		
        for (User u: getUserSet())
	    u.remove();
    }
	
	public void removeFileOrDirectory(String stringPath) {
		Path path = Paths.get(stringPath);
		
		try {
		    Files.delete(path);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
	}
	
	public void listFiles(String path) {
    	String[] p = path.split("/");
        String lastDir = p[p.length-1];
        File[] files = new File(lastDir).listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
            return;
        }
        System.out.println("No files were found."); //corrigir isto

    }
	
	public void xmlImport(String path) {
        ReadXMLFile reader = new ReadXMLFile();

        reader.read(path);
	}

    public void xmlExport(String path) {
        CreateXMLFile creator = new CreateXMLFile();

        creator.create(path);
    }
	
	/*public Document xmlExport() {
		Element element = new Element("mydrive");
		Document doc = new Document(element);

	    for (User u: getUserSet()) 
	    	//String usr = u.getUsername();
	    	element.addContent(u.xmlExport());
	    
	    return doc;
	}*/
	
	//ATENCAO verificar a utilidade deste metodo 
	public File resourceFile(String filename) {
		log.trace("Resource: "+filename);
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader.getResource(filename) == null) return null;
        return new java.io.File(classLoader.getResource(filename).getFile());
	}
    
}
