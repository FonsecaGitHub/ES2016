package pt.tecnico.mydrive.domain;

import java.io.*;
import java.io.File;
import java.util.Scanner;

import javax.lang.model.element.Element;

import pt.tecnico.mydrive.domain.MyDrive;
import pt.tecnico.mydrive.domain.User;

public class PlainFile extends PlainFile_Base {
	
	public PlainFile(MyDrive md) {
		super();
		setId(md.incNumberOfFiles());
		setMydrive(md);
	}
    
    public PlainFile(MyDrive root, String name, String content) {
        this(root);
        setName(name);
        setContent(content);
    }
    
    public void delete() {
    	//TODO ver se e preciso apagar o que esta pra tras
    	setOwner(null);
    	setMydrive(null);
    	deleteDomainObject();
    }
    
    //TODO Gil e isto que e preciso fazer
    /*
    public Element exportToXML() {
    	Element pf_element = new Element("PlainFile");
    	pf_element.setAttribute("_id", Integer.toString(getId()));
    	//...
    }*/
    
    
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
    
    @Override
    public String getType(){
    	return "Plain File";
    }
}
