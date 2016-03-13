package pt.tecnico.mydrive.domain;

public class SuperUser extends SuperUser_Base {
    
    public SuperUser() {
    	super();
    	setUsername("root");
    	setName("Super User");
    	setPassword("***");
    } 
}
