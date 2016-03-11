package pt.tecnico.mydrive;

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

import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;
import pt.tecnico.mydrive.domain.User;
import pt.tecnico.mydrive.domain.MyDrive;


public class SetupDomain {
	@Atomic
	public static void main(String[] args) {
		populateDomain();
	}
	
	static void populateDomain() {
		MyDrive md = MyDrive.getInstance();
		User user = new User("Miguel", "MiguelFonseca");
		md.addUser(user);
	}
}
