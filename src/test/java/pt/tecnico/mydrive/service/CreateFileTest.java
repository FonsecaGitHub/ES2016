package pt.tecnico.mydrive.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public class CreateFileTest extends AbstractServiceTest {
	
	private long userToken;
	private String name = "ola";
	private String type = "PlainFile";
	private String content = "ola mundo";
	
    protected void populate() {
    	MyDrive md = MyDrive.getInstance();

    	PlainFile f =  new PlainFile(10, name);
       
    }

   

    @Test
    public void success() {
    	CreateFileService service = new CreateFileService(userToken, name, type, content); 
    	service.execute();
    	
    	
    }
}