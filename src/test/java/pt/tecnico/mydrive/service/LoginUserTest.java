package pt.tecnico.mydrive.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.*;

public class LoginUserTest extends AbstractServiceTest {

	protected static final String USERNAME = "vasconcelos";
	protected static final String PASSWORD = "vasco";

    protected void populate() {
    	createUserService(USERNAME, PASSWORD, "Joao Vasconcelos");
    }

   

    @Test
    public void success() {
    	LoginUserService service = new LoginUserService(USERNAME, PASSWORD);
        service.execute;

       User user = getUserInSession(service.getUserByToken(token));
       assertEquals(USERNAME, user.getUsername());
       
    }

    @Test(expected = UserDoesNotExistsException.class)
    public void loginUnknownUser() {
        LoginUserService service = new LoginUserService("joao", "jv");
        service.execute();
    
    }

    @Test(expected = WrongPasswordException.class)
    public void loginUserWithWrongPassword() {
        LoginUserService service = new LoginUserService(USERNAME, "jffv");
        service.execute();
    
	}

}