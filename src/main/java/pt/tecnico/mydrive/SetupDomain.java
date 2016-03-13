package pt.tecnico.mydrive;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.io.File;
import java.nio.file.*;

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
import pt.tecnico.mydrive.domain.Directory;
import pt.tecnico.mydrive.domain.PlainFile;


public class SetupDomain {
	@Atomic
	public static void main(String[] args) {
		populateDomain();
	}
	
	static void populateDomain() {
		MyDrive md = MyDrive.getInstance();
		/*
		User user1 = new User("MiguelF", "Miguel Fonseca");
		User user2 = new User("JoãoV", "João Vasconcelos");
		User user3 = new User("TiagoK", "Tiago Kinas");
		md.addUser(user1);
		md.addUser(user2);
		md.addUser(user3);*/
		
		// 1 - Criar o ficheiro de texto...
		//PlainFile plainFile = new PlainFile();
		//plainFile.listUsers();
		
		/*
		// 2 - Criar a directoria...
		Directory directory = new Directory("MiguelPasta");
		directory.createDir("user\bin");
		*/
		// 3 - Imprimir o conteudo do ficheiro /home/README
		//System.out.println("O FICHEIRO README TEM: ");
		//plainFile.readFile("README");
		//
		// 4 - Remover directoria /usr/local/bin (working)
		//String pathToDelete = "dirTEST";
		//Path path = Paths.get(pathToDelete);
		//md.removeFileOrDirectory(path);
		
	}
	
	
}
