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
		
		SuperUser root = new SuperUser();
		md.addUser(root);
		
		// 1 - Criar o ficheiro de texto /home/README com o conteudo lista de utilizadores
		String filePath = "/home";
		String fileName = "/home/README.txt";
		PlainFile plainFile = new PlainFile(filePath, fileName);
		plainFile.writeListOfUsers(fileName); //TODO
		md.addPlainFile(plainFile); //TODO
		//
		// 2 - Criar a directoria /usr/local/bin
		String dirPath = "/usr/local/bin";
		String dirName = "bin";
		Directory directory = new Directory(dirPath, dirName);
		directory.createDir(dirPath); //TODO
		//
		// 3 - Imprimir o conteudo do ficheiro /home/README
		String fileToRead = "/home/README";
		try {
			plainFile.readFile(fileToRead);
		}
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		//
		// 4 - Remover directoria /usr/local/bin
		/*String pathToDelete = "/usr/local/bin";
		try {
			md.removeDirectory(pathToDelete); //TODO
			md.removeFileOrDirectory(pathToDelete);
		}
		catch(DirectoryDoesNotExistException ddne){
			ddne.printStackTrace();
		}*/
		//
		// 5 - Imprimir a exportacao em XML do sistema de ficheiros
		//path to /info folder on your local machine
		//String pathToInfoFolder = "C:\\Users\\sikrew\\essd2016\\mydrive\\info";
		//md.xmlExport(pathToInfoFolder); //TODO UNCOMMENT METHOD IN MD
		//
		// 6 - Remover o ficheiro /home/README
		/*String plainFileToDelete = "/home/README.txt";
		try {
			md.removePlainFile(plainFileToDelete); //TODO
			md.removeFileOrDirectory(plainFileToDelete);
		}
		catch(FileDoesNotExistException fdnee){
			fdnee.printStackTrace();
		}*/
		//
		// 7 - Imprimir a listagem simples da directoria /home
		//String pathToList = "/home";
		//md.listFiles(pathToList);
	}
	
	
}
