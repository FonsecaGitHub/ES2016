package pt.tecnico.mydrive.exception;

public class UsernameCannotBeNull extends MyDriveException {

    private static final long serialVersionUID = 1L;

    public UsernameCannotBeNull() {
        super("Error username cannot be Null");
    }
}
