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
	private Directory d; 
	private MyDrive md;
	private Session s;
	private User u;
	
	
    protected void populate() {
    	md = MyDrive.getInstance();
    	f = new PlainFile(md, name, content);
    	//u = md.getUserByToken(userToken);
    	u = new User(md,"joao","joao","123456");
    	s = u.getSession();
    	d = s.getWorkDir();
    }

    @Test
    public void createPlainFile() {
    	CreateFileService service = new CreateFileService(userToken, name, type, content); 
    	service.execute();
    	
    	assertEquals(d, f.getDir());
    	assertEquals(u, f.getOwner());
    	assertEquals(name, f.getName());
    	assertEquals(type, f.getType());
    	assertEquals(content, f.getContent());
    	
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
        CreateFileService service = new CreateFileService(userToken, name, "Texto", content); 
        service.execute();
    }
    @Test(expected = InvalidTokenException.class)
    public void invalidToken() {
        CreateFileService service = new CreateFileService(10, name, type, content); 
        service.execute();
    }
}