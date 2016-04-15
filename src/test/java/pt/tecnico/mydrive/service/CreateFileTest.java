package pt.tecnico.mydrive.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public class CreateFileTest extends AbstractServiceTest {
	
	private long userToken;
	private String name = "ola";
	private String type = "Plain File";
	private String content = "ola mundo";
	private PlainFile f;
	private MyDrive md;
	private User u;
	
	
    protected void populate() {
    	md = MyDrive.getInstance();
    	f = new PlainFile(md,name,content);
    	u = new User(md,"joao","feneja","123456");
    	userToken = u.getMyToken();
    }

    @Test
    public void createPlainFile() {
    	CreateFileService service = new CreateFileService(userToken, name, type, content); 
    	service.execute();
    	
    	assertEquals(u, f.getOwner());
    	assertEquals(name, f.getName());
    	assertEquals(type, f.getType());
    	assertEquals(content, f.getContent());
    	assertEquals(userToken, f.getOwner().getMyToken());
    }
   
   
    @Test(expected = FileNameAlreadyExistsException.class)
    public void fileNameAlreadyExists() {
        CreateFileService service = new CreateFileService(userToken, name, type, content); 
        service.execute();
    }
    
    @Test(expected = PlainFileNameAlreadyExistsException.class)
    public void plainfileNameAlreadyExists() {
        CreateFileService service = new CreateFileService(userToken, name, type, content); 
        service.execute();
    }
    
    @Test(expected = FileAlreadyExistsException.class)
    public void unauthorizedFileCreation() {
        CreateFileService service = new CreateFileService(userToken, name, type, content); 
        service.execute();
    }
    
    @Test(expected = InvalidFileTypeException.class)
    public void invalidType() {
    	String invType = "Texto";
        CreateFileService service = new CreateFileService(userToken, name, invType, content); 
        service.execute();
    }
    @Test(expected = InvalidTokenException.class)
    public void invalidToken() {
    	int token =10;
        CreateFileService service = new CreateFileService(token, name, type, content); 
        service.execute();
    }
}
