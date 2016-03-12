package pt.tecnico.mydrive.domain;

import java.io.File;

import org.jdom2.Element;
import org.jdom2.Document;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.ist.fenixframework.FenixFramework;

import pt.tecnico.mydrive.exception.UsernameAlreadyExistsException;
import pt.tecnico.mydrive.exception.UserDoesNotExistException;
import pt.tecnico.mydrive.exception.UsernameCannotBeNullException;

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
    
    public Directory getDirectoryByName(String name) {
        for (Directory directory : getDirectorySet()) {
            if (directory.getName().equals(name)) {
                return directory;
            }
        }
        return null;
    }
    
    public void addDirectory(String name) {
    	
    }
    
    public void removeDirectory(String name) {
    	Directory directoryToRemove = getDirectoryByName(name);
    	directoryToRemove.remove();
    }
	
	public void cleanup() {
		for (Directory d: getDirectorySet())
			d.remove();
		
        for (User u: getUserSet())
	    u.remove();
    }
	
	public void xmlImport(Element element) {
		for (Element node: element.getChildren("user")) {
		    String username = node.getAttribute("username").getValue();
		    String name = node.getAttribute("name").getValue();
		    User user = getUserByUsername(username);

		    if (user == null) // Does not exist
				user = new User(name, username);

		    user.xmlImport(node);
		}
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
