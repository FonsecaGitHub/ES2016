package pt.tecnico.mydrive.domain;

import org.jdom2.Element;

import pt.tecnico.mydrive.exception.ImportDocumentException;
import pt.tecnico.mydrive.exception.UsernameAlreadyExistsException;

public class File extends File_Base {
	
	protected File() { /* for derived classes */ }
	
	//TODO excepcao
    public File(int id, String name) {
		setId(id);
		setName(name);
		//setDatamod (new LocalTime());
	}
    
    //TODO excepcao
    protected void init(int id, String name) {
    	setId(id);
    	setName(name);
    }
    
    public File(int id, Element xml) {
    	//xmlImport(xml);
    	setId(id);
    }
    
    @Override
    public void setUser(User user) throws UsernameAlreadyExistsException {
        if (user == null) {
            super.setUser(null);
            return;
        }

        user.addFile(this);
    }

	public void delete() {
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
    
}
