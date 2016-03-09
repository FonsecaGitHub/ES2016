package pt.tecnico.mydrive.domain;

import java.io.File;

import org.jdom2.Element;
import org.jdom2.Document;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.ist.fenixframework.FenixFramework;
//ATENCAO ver se aqui e suposto usar name em vez de username
import pt.tecnico.mydrive.exception.UsernameAlreadyExistsException;

public class MyDrive extends MyDrive_Base {
    
    /*public MyDrive() {
        super();
    }*/

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
    
    //ATENCAO ver se aqui e suposto usar name em vez de username
    public User getUserByName(String name) {
        for (User user : getUserSet()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
    
    public boolean hasUser(String userName) {
        return getUserByName(userName) != null;
    }
    
    //ATENCAO ver se aqui e suposto usar name em vez de username
    @Override
    public void addUser(User userToBeAdded) throws UsernameAlreadyExistsException {
        if (hasUser(userToBeAdded.getName()))
            throw new UsernameAlreadyExistsException(userToBeAdded.getName());

        super.addUser(userToBeAdded);
    }
    
}
