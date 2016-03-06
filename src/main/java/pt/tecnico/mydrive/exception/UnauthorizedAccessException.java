package pt.tecnico.mydrive.exception;

public class UnauthorizedAccess extends MyDriveException {

    private static final long serialVersionUID = 1L;

    public UnauthorizedAccess() {
        super("Unauthorized access to a file");
    }
}
