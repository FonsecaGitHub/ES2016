package pt.tecnico.mydrive;

import pt.tecnico.mydrive.domain.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;
public class MydriveApplication {
    static final Logger log = LogManager.getRootLogger();

    public static void main(String[] args) throws IOException {
        System.out.println("*** Welcome to the MyDrive application! ***");
        /*try {
        	setup();
        	for (String s: args) xmlScan(new File(s));
        	print();
        	xmlPrint();
        } finally { FenixFramework.shutdown(); }*/
	}
    
    @Atomic
    public static void init() { // empty mydrive
    	log.trace("Init: " + FenixFramework.getDomainRoot());
    	MyDrive.getInstance().cleanup();
    }
    
    //ATENCAO fazer isto de acordo com os pedidos dos profs
    
    @Atomic
    public static void setup() { // mydrive with debug data
    	/*
    	log.trace("Setup: " + FenixFramework.getDomainRoot());
    	MyDrive md = MyDrive.getInstance();
    	User user;
    	
    	if (!md.getUserSet().isEmpty()) return;
    	
    	// setup the initial state if mydrive is empty
    	User = new User(md, "Miguel");*/
    }
    
    @Atomic 
    public static void print() {
    	/*log.trace("Print: " + FenixFramework.getDomainRoot());
    	MyDrive md = MyDrive.getInstance();
    	
    	for (User u: md.getUserSet()) {
    		System.out.println("The user: " + p.getName() + " has " + u.getFileSet().size() + " files :");
    		for (File f: u.getFileSet())
    			System.out.println("\t" + f.getName());
    	}*/
    }
    
    @Atomic
    public static void xmlPrint() {
    	
    }
    
    @Atomic public static void xmlScan(File file) {
    	
    }
}
