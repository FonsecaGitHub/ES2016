package pt.tecnico.mydrive.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public class ReadFileTest extends AbstractServiceTest {
	
	private long userToken;
	private String filename = "ola";
	private String type = "Plain File";
	private String content = "ola mundo";
	private PlainFile f;
	private Directory dir;
	private MyDrive md;
	private User u;

    protected void populate() {
    	md = MyDrive.getInstance();
    	f = new PlainFile(md, filename, content);
    	u = md.getUserByToken(userToken);
    	dir = new Directory();
    }

   

    @Test
    public void ReadFile() {
    	ReadFileService service = new ReadFileService(userToken, filename); 
    	service.execute();
    	
    	assertEquals(u, f.getOwner());
    	assertEquals(filename, f.getName());
    	assertEquals(type, f.getType());
    	assertEquals(content, f.getContent());
    }
    
    @Test(expected = FileDoesNotExistException.class)
    public void FileDoesNotExist() {
        ReadFileService service = new ReadFileService(userToken, "PIU PIU"); 
        service.execute();
    }
    
    @Test(expected = WrongFileTypeToReadException.class)
    public void WrongFileTypeToRead() {
        ReadFileService service = new ReadFileService(userToken, dir.getName()); 
        service.execute();
    }
    
    @Test(expected = UnauthorizedOperationException.class)
    public void UnauthorizedOperation() {
        ReadFileService service = new ReadFileService(userToken, filename); 
        service.execute();
    }
    
    
    
}