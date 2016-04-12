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

    public Directory getCurrentDirectory() {
        return getSession().getWorkDir();
    }

    public void setCurrentDirectory(Directory newdir){
        getSession().setWorkingdirectory(newdir); //pode precisar de mudar o ID mas não sei
    }

    public boolean isValid(){
        DateTime now = new DateTime();
        if (this.getInitialDate().isAfter(now.minusHours(2))) 
            return true;
        else
            return false;
   }

    public void dateReset(){
        setInitialDate(new DateTime().plusHours(2));
    }

}