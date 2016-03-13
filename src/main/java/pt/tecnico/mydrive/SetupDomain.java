package pt.tecnico.mydrive;

import java.io.*;
import java.io.File;
import java.nio.file.Paths;
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

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.DirectoryDoesNotExistException;
import pt.tecnico.mydrive.exception.FileDoesNotExistException;


public class SetupDomain {
	@Atomic
	public static void main(String[] args) {
		try {
			populateDomain();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void populateDomain() throws IOException {
		MyDrive md = MyDrive.getInstance();
		/*
		User user1 = new User("MiguelF", "Miguel Fonseca");
		User user2 = new User("JoãoV", "João Vasconcelos");
		User user3 = new User("TiagoK", "Tiago Kinas");
		md.addUser(user1);
		md.addUser(user2);
		md.addUser(user3);*/
		
		SuperUser root = new SuperUser();
		md.addUser(root);
		
		// 1 - Criar o ficheiro de texto /home/README com o conteudo lista de utilizadores
		String filePath = "\\home";
		String fileName = "README.txt";
		PlainFile plainFile = new PlainFile(filePath, fileName);
		plainFile.writeListOfUsers(fileName);
		md.addPlainFile(plainFile);
		//
		// 2 - Criar a directoria /usr/local/bin
		String dirPath = "\\usr\\local\\bin";
		String dirName = "bin";
		Directory directory = new Directory(dirPath, dirName);
		directory.createDir("user\\local\\bin");
		//
		// 3 - Imprimir o conteudo do ficheiro /home/README
		String fileToRead = "home\\README.txt";
		try {
			plainFile.readFile("fileToRead");
		}
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		//
		// 4 - Remover directoria /usr/local/bin
		String pathToDelete = "usr\\local\\bin";
		Path path1 = Paths.get(pathToDelete);
		try {
			md.removeDirectory(pathToDelete);
			md.removeFileOrDirectory(path1);
		}
		catch(DirectoryDoesNotExistException ddne){
			ddne.printStackTrace();
		}
		//
		// 5 - Imprimir a exportacao em XML do sistema de ficheiros
		md.xmlExport("C:\\Users\\sikrew\\essd2016\\mydrive\\info"); //path to /info folder on your local machine

		// 6 - Remover o ficheiro /home/README
		String plainFileToDelete = "home\\README.txt";
		Path path2 = Paths.get(plainFileToDelete);
		try {
			md.removePlainFile(plainFileToDelete);
			md.removeFileOrDirectory(path2);
		}
		catch(FileDoesNotExistException fdnee){
			fdnee.printStackTrace();
		}
		//
		// 7 - Imprimir a listagem simples da directoria /home
		String pathToList = "dirTEST";
		md.listFiles(pathToList);
	}
	
	
}
