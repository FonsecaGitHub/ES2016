package pt.tecnico.mydrive.domain;

import org.jdom2.Element;

import pt.tecnico.mydrive.domain.File;

public class Permissions extends Permissions_Base {

	public Permission(User user, File file) {
		super();
		setUser(user);
		setFile(file);

	}

	public void delete() {
		setUser(null);
		setFile(null);
		deleteDomainObject();
	}

	public Element exportToXML() {
		Element permissionsElement = new Element("permissions");
		//permissionElement.setAttribute("acess-type", getAccess().toString());
		File file = getFile();
		permissionsElement.addContent(file.exportToXML());

		return permissionsElement;
	}

	public void importFromXML(Element permissionsElement) {

	}

}
