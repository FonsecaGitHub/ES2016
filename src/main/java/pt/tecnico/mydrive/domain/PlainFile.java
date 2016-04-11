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
        //TODO
    }
}
