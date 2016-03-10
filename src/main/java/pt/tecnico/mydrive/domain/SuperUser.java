package pt.tecnico.mydrive.domain;

public class SuperUser extends SuperUser_Base {
    
    public SuperUser() {
        super();
    }
    
    public SuperUser(MyDrive md) {
    	super();
    	setMydrive(md);
    	setUsername("root");
    	setName("Super User");
    	setPassword("***");
    } 
}
