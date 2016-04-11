package pt.tecnico.mydrive.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public class CreateFileTest extends AbstractServiceTest {
	
	private long token;
	
	private static final int FILE_ID = 10;
	
	private static final String FILE_NAME = "";
	private static final String FILE_TYPE = "";
	private static final String FILE_CONTENT = "";
	
    protected void populate() {
    	File f= new File(FILE_ID, FILE_NAME);
		token = addUserToSession();
    }

   

    @Test
    public void success() {
    	CreateFileService service = new CreateFileService(token,FILE_NAME, FILE_TYPE, FILE_CONTENT);
		service.execute();
		
		File file = getFileByName(FILE_NAME);
		
		assertEquals(FILE_NAME, getFileByName(FILE_NAME).getName());
		assertEquals(FILE_TYPE, file.getType());
		assertEquals(FILE_CONTENT, file.getContent());
    }
}