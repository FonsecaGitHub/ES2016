package pt.tecnico.mydrive.domain;

import java.io.*;
import java.lang.reflect.Method;
import java.util.List;

import pt.tecnico.mydrive.domain.MyDrive;
import pt.tecnico.mydrive.exception.UserIsNotInSessionException;


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

    public PlainFile(){
        super();
    }

    public PlainFile(String filepath, String filename){
        super();
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
    public void execute(User u, List<String> args){
		if (!u.isInSession()) {
			throw new UserIsNotInSessionException(u.getMyToken());
		}/*
		Class<?> cls;
		Method meth;
		String name = "PlainFile";
		try { // name is a class: call main()
			cls = Class.forName(name);
			meth = cls.getMethod("readFile", void[].class);
		} 
		catch (ClassNotFoundException cnfe) { // name is a method
			int pos;
			if ((pos = name.lastIndexOf('.')) < 0)
				throw cnfe;
			cls = Class.forName(name.substring(0, pos));
			meth = cls.getMethod(name.substring(pos + 1), String[].class);
		}
		meth.invoke(null, (Object) args); // static method (ignore return)*/
	}

	
    
    @Override
    public String getType(){
    	return "Plain File";
    }
}
