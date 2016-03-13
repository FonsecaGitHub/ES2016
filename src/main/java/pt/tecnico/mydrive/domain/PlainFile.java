package pt.tecnico.mydrive.domain;

import java.io.*;
import java.io.File;
import java.util.Scanner;

import pt.tecnico.mydrive.domain.MyDrive;
import pt.tecnico.mydrive.domain.User;

public class PlainFile extends PlainFile_Base {
	
	public PlainFile() {
		super();
	}
    
    public PlainFile(String path, String name) {
        super();
        setPath(path);
        setName(name);
    }
    
    
    public void readFile(String path) throws FileNotFoundException, IOException{
    	BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            for (String line; (line = br.readLine()) != null; ) {
                System.out.println(line);
            }
        }
        catch(FileNotFoundException e){
            //e.printStackTrace();
            System.out.println(e.toString());
        }
        catch(IOException e){
            //e.printStackTrace();
            System.out.println(e.toString());
        }
    }
    
    	
    
    public void writeListOfUsers(String fileName) {
    	MyDrive md = MyDrive.getInstance();
    	
    	FileWriter file = null;
        try {
            try {
                file = new FileWriter(fileName);
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
