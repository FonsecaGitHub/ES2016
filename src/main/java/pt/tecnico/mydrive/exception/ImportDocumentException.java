package pt.tecnico.mydrive.exception;

public class ImportDocumentException extends MyDriveException {

    private static final long serialVersionUID = 1L;

    public ImportFileException() {
        super("Error in importing document from XML");
    }
}
