package pt.tecnico.mydrive.exception;

public class WrongFileTypeToReadException extends MyDriveException {

    private static final long serialVersionUID = 1L;

    public WrongFileTypeToReadException() {
        super("Content needs to be a String type");
    }
}