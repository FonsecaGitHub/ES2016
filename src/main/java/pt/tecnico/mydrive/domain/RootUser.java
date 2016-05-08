package pt.tecnico.mydrive.domain;

import org.joda.time.DateTime;

public class RootUser extends RootUser_Base {
    
    public RootUser() {
        super();
        setUsername("root");
        setName("Super User");
        setPassword("***");
    }
}
