package pt.tecnico.mydrive.exception;

public class ContentNeedsToBeStringException extends MyDriveException {

    private static final long serialVersionUID = 1L;

    public ContentNeedsToBeStringExceptionException() {
        super("Content needs to be a String type");
    }
}