package pt.tecnico.mydrive.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public class CreateFileTest extends AbstractServiceTest {
	
	private long userToken;
	
	private int id = 10;
	private String name = "ola";
	private String type = "File";//verificar qual o type do file
	private String content = "ola mundo";
	
    protected void populate() {
    	MyDrive md = MyDrive.getInstance();
    	// o que populamos?
    	File f =  new File(id, name);
       
    }

   

    @Test
    public void success() {
    	CreateFileService service = new CreateFileService(userToken, name, type, content); 
    	service.execute();
    	
    	File f = new File (id, name);
    	assertEquals(id, f.getId());
    	assertEquals(name, f.getName());
    	assertEquals(type, f.getType());
    	//verifica-se o content? e o token?
    }
    
    //corrigir teste
    @Test(expected = FileAlreadyExistsException.class)
    public void unauthorizedFileCreation() {
        CreateFileService service = new CreateFileService(userToken, name, type, content); 
        service.execute();
    }
    
}