package pt.tecnico.mydrive.domain;

public class GuestUser extends GuestUser_Base {
    
    public GuestUser() {
        super();
        setUsername("nobody");
        setName("Guest");
        setPassword("");
        setMask("rxwdr-x-");
    }
}
