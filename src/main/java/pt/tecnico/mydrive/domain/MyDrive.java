package pt.tecnico.mydrive.domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import org.jdom2.Element;
import org.jdom2.Document;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.ist.fenixframework.FenixFramework;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.service.CreateXMLFile;
import pt.tecnico.mydrive.service.ReadXMLFile;

public class MyDrive extends MyDrive_Base {
	static final Logger log = LogManager.getRootLogger();

	public static MyDrive getInstance() {
		MyDrive md = FenixFramework.getDomainRoot().getMydrive();
		if (md != null)
			return md;

		log.trace("new MyDrive");
		return new MyDrive();
	}

	private MyDrive() {
		setRoot(FenixFramework.getDomainRoot());
	}

	public void incNumberOfFiles() {
		int files = getNumberOfFiles();
		files++;
		setNumberOfFiles(files);
	}

	public void incNumberOfUsers() {
		int users = getNumberOfUsers();
		users++;
		setNumberOfUsers(users);
	}
	
	//Vasconcelos faz excepcao
	public String loginUser(String username, String password) throws LoginMyDriveException {
		User user = getUserByName(username);
		if (user == null || user.getPassword() == null) {
			throw new LoginMyDriveException();
		}
		user.createSession();
		return user.getToken();
	}

	public User getUserByUsername(String username) throws UserDoesNotExistException {
		for (User user : getUserSet()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	// JOAO EXCEPCAO
	/*
	 * public User getUserByToken(String token) throws
	 * UserIsNotInSessionException { for (User user : getUserSet()) { if
	 * (user.isInSession() && user.getToken().equals(token)) { return user; } }
	 * return null; }
	 */

	// PARA APAGAR
	/*
	 * public User updateUserLastAccess(String token) { User user =
	 * getUserByToken(token); user.updateSession(); }
	 */

	public boolean hasUser(String username) {
		return getUserByUsername(username) != null;
	}

	// @Override
	public void addUser(User userToBeAdded) throws UsernameAlreadyExistsException {

		if (hasUser(userToBeAdded.getUsername()))
			throw new UsernameAlreadyExistsException(userToBeAdded.getUsername());
		/*
		 * //JOAO VE ESTA EXCEPCAO if (getUserByUsername(username) != null) {
		 * throw new DuplicateUsernameException(username); }
		 * 
		 * //JOAO ADICIONA ESTA EXCEPCAO if(username.isEmpty()) { throw new
		 * EmptyUsernameException(); }
		 * 
		 * //JOAO ADICIONA ESTA EXCEPCAO if (username.equals("root")) { throw
		 * new UnauthorizedOperationException(); }
		 */
		super.addUser(userToBeAdded);
	}

	public void removeUser(String username) {
		if (username.equals("root")) {
			// JOAO ADICIONA ESTA EXCEPCAO
			// throw new UnauthorizedOperationException();
		} else {
			User userToRemove = getUserByUsername(username);
			if (userToRemove == null) {
				throw new UserDoesNotExistException(username);
			}
			// Ainda nao e necessario para esta entrega
			/*
			 * for (Permission permission : userToRemove.getPermissionSet()) {
			 * if (permission.getAccess() == Access.OWNS) { File file =
			 * permission.getFile(); file.remove(); } }
			 */
			userToRemove.remove();
		}
	}

	public void cleanup() {
		for (User u : getUserSet())
			u.remove();
	}

	public void removeFileOrDirectory(String stringPath) {
		Path path = Paths.get(stringPath);

		try {
			Files.delete(path);
		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
			System.err.format("%s not empty%n", path);
		} catch (IOException x) {
			// File permission problems are caught here.
			System.err.println(x);
		}
	}

	public void listFiles(String path) {
		String[] p = path.split("/");
		String lastDir = p[p.length - 1];
		File[] files = new File(lastDir).listFiles();

		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					System.out.println(file.getName());
				}
			}
			return;
		}
		System.out.println("No files were found."); // corrigir isto

	}

	/*
	public void xmlImport(String path) {
		ReadXMLFile reader = new ReadXMLFile();

		reader.read(path);
	}

	public void xmlExport(String path) {
		CreateXMLFile creator = new CreateXMLFile();

		creator.create(path);
	}*/

	/*
	 * public Document xmlExport() { Element element = new Element("mydrive");
	 * Document doc = new Document(element);
	 * 
	 * for (User u: getUserSet()) //String usr = u.getUsername();
	 * element.addContent(u.xmlExport());
	 * 
	 * return doc; }
	 */

	// ATENCAO verificar a utilidade deste metodo
	public File resourceFile(String filename) {
		log.trace("Resource: " + filename);
		ClassLoader classLoader = getClass().getClassLoader();
		if (classLoader.getResource(filename) == null)
			return null;
		return new java.io.File(classLoader.getResource(filename).getFile());
	}

}
