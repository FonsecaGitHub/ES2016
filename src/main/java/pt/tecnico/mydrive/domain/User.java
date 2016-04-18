package pt.tecnico.mydrive.domain;

import org.jdom2.Element;

import pt.tecnico.mydrive.exception.*;

public class User extends User_Base {

	private long myToken;

	public User() {
		super();
	}

	public User(MyDrive md, String username, String name, String password) throws InvalidUsernameException {
		super();
		if (username.length() < 3 || !isAlphaNumeric(username)) {
			throw new InvalidUsernameException(username);
		}
		setUsername(username);
		setName(name);
		setPassword(password);
	}

	public User(MyDrive md, Element xml) {
		super();
		// xmlImport(xml);
		setMydrive(md);
	}

	@Override
	public void setMydrive(MyDrive md) {
		if (md == null)
			super.setMydrive(null);
		else
			md.addUser(this);
	}

	public boolean isAlphaNumeric(String s) {
		String pattern = "^[a-zA-Z0-9]*$";
		if (s.matches(pattern)) {
			return true;
		}
		return false;
	}

	@Override
	public void addFile(File fileToBeAdded) throws FileNameAlreadyExistsException {
		if (hasFile(fileToBeAdded.getName()))
			throw new FileNameAlreadyExistsException(fileToBeAdded.getName());

		super.addFile(fileToBeAdded);
	}

	// ATENCAO aqui talvez seja por ID em vez de ser por nome
	public File getFileByName(String name) {
		for (File file : getFileSet())
			if (file.getName().equals(name))
				return file;
		return null;
	}

	public boolean hasFile(String fileName) {
		return getFileByName(fileName) != null;
	}
	
	

	// HANDLES DIRECTORY
	public Directory getDirectoryByPath(String path) {
		for (Directory directory : getDirectorySet()) {
			if (directory.getPath().equals(path)) {
				return directory;
			}
		}
		return null;
	}

	public boolean hasDirectory(String path) {
		return getDirectoryByPath(path) != null;
	}

	public void addDirectory(Directory directoryToBeAdded) throws DirectoryNameAlreadyExistsException {
		if (hasDirectory(directoryToBeAdded.getPath()))
			throw new DirectoryNameAlreadyExistsException(directoryToBeAdded.getPath());

		super.addDirectory(directoryToBeAdded);
	}

	public void removeDirectory(String path) {
		Directory directoryToRemove = getDirectoryByPath(path);
		if (directoryToRemove == null) {
			throw new DirectoryDoesNotExistException(path);
		}
		for (File f : directoryToRemove.getOwnedSet()){
			f.delete();
		}
		directoryToRemove.remove();
	}
	
	

	// HANDLES PLAINFILE
	public PlainFile getPlainFileByPath(String path) {
		for (PlainFile plainFile : getPlainfileSet()) {
			if (plainFile.getPath().equals(path)) {
				return plainFile;
			}
		}
		return null;
	}

	public boolean hasPlainFile(String path) {
		return getPlainFileByPath(path) != null;
	}

	// JOAO ARRANJA UMA EXCEPCAO MELHOR
	public void addPlainFile(PlainFile plainFileToBeAdded) throws FileNameAlreadyExistsException {
		if (hasPlainFile(plainFileToBeAdded.getPath()))
			throw new FileNameAlreadyExistsException(plainFileToBeAdded.getPath());

		super.addPlainfile(plainFileToBeAdded);
	}

	public void removePlainFile(String path) {
		PlainFile plainFileToRemove = getPlainFileByPath(path);
		if (plainFileToRemove == null) {
			throw new FileDoesNotExistException(path);
		}
		plainFileToRemove.delete();
	}

	// ATENCAO ver se e preciso eliminar os ficheiros antes de eliminar o User
	public void remove() {
		/*
		 * for (Permission permission : getPermissionSet()) {
		 * permission.remove(); }
		 */
		setMydrive(null);
		deleteDomainObject();
	}


	public void delete() {
		//apagar o que ta pra tras
		if(getMytoken() != null)
			getMytoken().delete();
		setMydrive(null);
		deleteDomainObject();
	}
	  

	 
	  public Boolean isInSession() { 
		  if (getSession() != null) { 
			  return true; 
		  }
		  else return false; 
	  }
	 

	public boolean isRoot() {
		return getUsername().equals("root");
	}

	public long getMyToken() {
		return myToken;
	}

	public void setMyToken(long myToken) {
		this.myToken = myToken;
	}
}
