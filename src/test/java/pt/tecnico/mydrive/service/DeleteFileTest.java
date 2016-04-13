package pt.tecnico.mydrive.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public class DeleteFileTest extends AbstractServiceTest {

	private long userToken;
	
	private static final int FILE_ID = 20;
	private static final String FILE_NAME = "Test";
	private static final String FILE_NAMES = "Dir";
	private static final String FILE_TYPE = "File";
	private static final String FILE_TYPE_DIRECTORY = "Directory";
	private static final String FILE_PATH = "x/y/z";
	
	private static final String USER_NAME = "Antonio";
	private static final String USER_USERNAME = "To";
	private static final String USER_PASSWORD = "xpto";
	
	
	
    protected void populate() {
    	MyDrive md = MyDrive.getInstance();
    	User user = new User(md, USER_USERNAME, USER_NAME, USER_PASSWORD);
    	File f = new File(md, FILE_ID, FILE_NAME); //Falta qualquer coisa
    	Directory dir = new Directory(FILE_PATH, FILE_NAMES);
    	
    }

   

    @Test
    public void success() {
       DeleteFileService service = new DeleteFileService(userToken, FILE_NAME);
       service.execute();
    
       assertNull(f.getFile(FILE_ID));    
    }
    
    
    
}