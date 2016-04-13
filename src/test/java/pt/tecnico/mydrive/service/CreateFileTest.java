package pt.tecnico.mydrive.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public class CreateFileTest extends AbstractServiceTest {
	
	private long userToken;
	private String name = "ola";
	private String type = "File";
	private String content = "ola mundo";
	private PlainFile f;
	private Directory d; 
	private MyDrive md;
	private Session s;
	private User u;
	
	
    protected void populate() {
    	md = MyDrive.getInstance();
    	f = new PlainFile(md, name, content);
    	u = md.getUserByToken(userToken);
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
  
    //insucesso token invalido, nome maior 
    //corrigir teste
    @Test(expected = FileAlreadyExistsException.class)
    public void unauthorizedFileCreation() {
        CreateFileService service = new CreateFileService(userToken, name, type, content); 
        service.execute();
    }
    
}