package pt.tecnico.mydrive.domain;

import org.jdom2.Element;
import org.joda.time.DateTime;

import pt.tecnico.mydrive.exception.ImportDocumentException;
import pt.tecnico.mydrive.exception.UsernameAlreadyExistsException;

public class File extends File_Base {
	
	protected File() { /* for derived classes */ }
	
	/**
	 * Cria um ficheiro iniciando apenas o id, e adiciona-a a aplicacao
	 * @param rootObject
	 */
    public File(MyDrive md) {
		super();
		
		setId(md.incNumberOfFiles());
		setMydrive(md); //Adiciona este file a aplicacao
	}

	public File getFile(int id){ //TODO só aqui para compilar - nao faz sentido
		return this;
	}
    
    /**
     * Cria um ficheiro inciando todos os atributos desta
	 * @param rootObject
     * @param nome do ficheiro
	 * @param id
	 */
    public File(MyDrive root, int id, String name) {
    	this(root);
    	setName(name);
		//TODO something with id
    	setDatamod(new DateTime());
    	
    }

	public void delete() {
		setOwner(null);
		deleteDomainObject();
	}
	
	//TODO
	public void xmlImpport(Element fileElement) throws ImportDocumentException {

	}
	
	//TODO
	public Element xmlExport() {
		Element element = new Element("file");
		
        return element;
			
	}
    
	public String getType(){
		return "File";
	}
	 public String toString(){
		 return getType() + " " + getOwner().getUsername() + " " + getId() + " " + getDatamod() + " " + getName() + "\n";
	 }
}
