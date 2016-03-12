package pt.tecnico.mydrive.domain;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.StringWriter;

import pt.tecnico.mydrive.domain.MyDrive;
import pt.tecnico.mydrive.domain.User;

public class PlainFile extends PlainFile_Base {
    
    public PlainFile() {
        super();
    }
    
    
    public void listUsers() {
    	MyDrive md = MyDrive.getInstance();
    	
    	FileWriter file = null;
        try {
            try {
                file = new FileWriter("README.txt");
                String user;
                for (User u: md.getUserSet()) {
            		user = (u.getUsername());
                    System.out.println(user);
                    int length = user.length();
                    file.write(user);
                    file.write(System.getProperty( "line.separator" ));
                    if (length == 30) {
                        user = " ";
                    }
                }
            } finally {
                file.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
