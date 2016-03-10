package pt.tecnico.mydrive.domain;

import org.jdom2.Element;
import org.jdom2.DataConversionException;
import java.io.UnsupportedEncodingException;

public class File extends File_Base {
    
    public File() {
        super();
    }

    /*public File(int id, String name) {
		super();
		setId(id);
		setName(name);
		setDate (new LocalTime());
	}

	public void delete() {
		// Ver se e necessario remover todas as linhas do ficheiro, ou
		// se isso vai ser feito pelas subclasses de File
		for (Permissions permissions : getPermissionsSet()) {
			permissions.delete();
		}
		deleteDomainObject();
	}

	//TODO
	public Element exportToXML() {

	}

	//TODO
	public void importFromXML(Element fileElement)
		throws DataConversionException {
			
		}*/
    
}
