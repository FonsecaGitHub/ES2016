package pt.tecnico.mydrive.domain;

import java.util.Random;
import org.joda.time.*;

//MUDAR NOME DA CLASSE PARA LOGIN

public class Session extends Session_Base {
    
    public Session(User user) {
        super();
        setUserInSession(user);
       // setToken(user.getUsername() + new Random().nextInt(10));
        //renewSession();
    }
    
    public Session(User user, long token) {
    	super();
    	setUserInSession(user);
    	setToken(token);
    }
    
    public void renewSession() {
    	setLastTimeInSession(new LocalTime());
    }
    
	public void delete() {
		getUserInSession().setSession(null);
		setUserInSession(null);
		deleteDomainObject();
	}
	
	public Directory getWorkingDirectory() {
		Directory dir = this.getWorkingDirectory();
		return dir;
	}
	
	/*
	public void reloadToken() {
		long newToken = (getUserInSession().getUsername() + new Random().nextInt(10));
		while (newToken.equals(getToken())) {
			newToken = (getUserInSession().getUsername() + new Random().nextInt(10));
		}
		setToken(newToken);
	}*/ 
    
}
