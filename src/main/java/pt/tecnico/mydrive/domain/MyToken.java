package pt.tecnico.mydrive.domain;

public class MyToken extends MyToken_Base {
    
    public MyToken() {
        super();
    }
    
    public MyToken(long token, User user) {
    	super();
    	user.setMyToken(token);
    	//if(user.getMyToken()!=null) rever isto! TODO
    	//	user.getMyToken().delete();
    	setUser(user);
    }
    
    public void delete() {
    	setUser(null);
    	setSession(null);
    	deleteDomainObject();
    }



}