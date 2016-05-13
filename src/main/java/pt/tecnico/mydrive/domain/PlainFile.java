package pt.tecnico.mydrive.domain;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    
    
    public void doExecute(User u, String programName, List<String> args){
		if (!u.isInSession()) {
			throw new UserIsNotInSessionException(u.getMyToken());
		}
		/*String input;
		Thread master = Thread.currentThread();
		Scanner scan = new Scanner(System.in);

		ProcessBuilder builder;
		if (args.size() == 0)
			builder = new ProcessBuilder(args);
		else {
			java.util.List<String> l = new ArrayList<String>();
			for (String s : args)
				l.add(s);
			builder = new ProcessBuilder(l);
		}
		builder.redirectErrorStream(true);
		Process proc = builder.start();
		OutputStream stdin = proc.getOutputStream();
		InputStream stdout = proc.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));


	    Thread throut = new Thread(new Runnable() {
	    @Override
	    public void run() {
	    	String line;
	    	try {
	    		while ((line = reader.readLine ()) != null) {
	    			out.println ("Stdout: " + line);
	    		}
	    	} catch (IOException e) { e.printStackTrace(); }
	    		System.err.println ("Stdout is now closed!!!");
	      	}
	    }

		for (;;) {
			do
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			while (proc.isAlive() && !scan.hasNext());
			if (proc.isAlive()) {
				if ((input = scan.nextLine()) != null) {
					writer.write(input);
					writer.newLine();
					writer.flush();
				}
			} else
				break;
		}
	
		try {
			proc.waitFor();
		} catch (InterruptedException e) {}

		System.err.println("exit: " + proc.exitValue());
		proc.destroy();*/
	}
    
    @Override
	public void execute(User u,  List<String> args) {
		if (getContent() != null) {
			String[] arguments = getContent().split("\n");
			for (int i = 0; i < arguments.length; i++) {
				String[] a = arguments[i].split(" ");
				//doExecute(u,u.getFileAssociations().get(arguments[i]),a);
			}
		}
	}

	
    
    @Override
    public String getType(){
    	return "Plain File";
    }
}
