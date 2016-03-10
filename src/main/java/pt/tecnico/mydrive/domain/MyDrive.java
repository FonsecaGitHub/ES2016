package pt.tecnico.mydrive.domain;

import java.io.File;

import org.jdom2.Element;
import org.jdom2.Document;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.ist.fenixframework.FenixFramework;

import pt.tecnico.mydrive.exception.UsernameAlreadyExistsException;
import pt.tecnico.mydrive.exception.UserDoesNotExistException;

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
	
	public void cleanup() {
        for (User p: getUserSet())
	    p.remove();
    }
	
	/*public void xmlImport(Element element) {
		for (Element node: element.getChildren("person")) {
		    String username = node.getAttribute("username").getValue();
		    User user = getUserByUsername(username);

		    if (person == null) // Does not exist
				user = new User(this, username);

		    user.xmlImport(node);
		}
		
	}
	
	public Document xmlExport() {
		Element element = new Element("mydrive");
		Document doc = new Document(element);

	    for (User p: getUserSet())
	    	element.addContent(p.xmlExport());
	    
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
