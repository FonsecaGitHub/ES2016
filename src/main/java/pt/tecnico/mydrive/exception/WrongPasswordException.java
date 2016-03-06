package pt.tecnico.mydrive.exception;

public class WrongPassword extends MyDriveException {

    private static final long serialVersionUID = 1L;

    public WrongPassword() {
        super("Password wrong please try again");
    }
}