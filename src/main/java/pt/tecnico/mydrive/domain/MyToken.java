package pt.tecnico.mydrive.domain;

import org.joda.time.DateTime;

public class MyToken extends MyToken_Base {
    
    public MyToken() {
        super();
    }
    
    public MyToken(long token, User user) {
    	super();
    	setToken(token);
    	setInitialDate(new DateTime());
    	if(user.getMytoken()!=null)
    		user.getMytoken().delete();
    	setUser(user);
    }
    
    public void delete() {
    	setUser(null);
    	setSession(null);
    	deleteDomainObject();
    }
/*
    public Directory getCurrentDirectory() {
        return getSession().getWorkDir();
    }

    public void SetCurrentDirectory(Directory newdir){

    }*/
}
