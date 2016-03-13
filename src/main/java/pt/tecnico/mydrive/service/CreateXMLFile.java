package pt.tecnico.mydrive.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateXMLFile {
    public void create(String path) {

        String thePath = path;

        try {

            System.out.println("Start try");

            Element mydrive = new Element("mydrive");
            Document doc = new Document(mydrive);
            System.out.println(doc.getRootElement());

            System.out.println("before create user");

            createUser(doc, "Francisco", "/home/francisco", "a senha do francisco", "rwxd----");
            createUser(doc, "Maria", "/home/maria", "a senha da maria", "rwxd----");

            //createFile(doc, id, type, owner, name,  parent, children, method, datamod)
            createFile(doc, "1", "dir", "Francisco", "directory1",  "/home/francisco", null, null, null);
            createFile(doc, "2", "plain", "Francisco", "plainFile1",  null, null, null, null);
            createFile(doc, "3", "plain", "Maria", "plainFile1",  null, null, null, null);

            // output para o terminal
            // new XMLOutputter().output(doc, System.out);

            // output para ficheiro
            XMLOutputter xmlOutput = new XMLOutputter();


            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(path));

            System.out.println("File Saved!");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    private void createFile(Document doc, String id, String type, String owner, String name, String parent,
                            String children, String method, String datamod) {
        Element file = new Element("file");
        file.setAttribute(new Attribute("id", id));
        file.addContent(new Element("type").setText(type));
        file.addContent(new Element("owner").setText(owner));
        file.addContent(new Element("name").setText(name));
        file.addContent(new Element("parent").setText(parent));
        file.addContent(new Element("children").setText(children));
        file.addContent(new Element("method").setText(method));
        file.addContent(new Element("datamod").setText(datamod));

        System.out.println("createFile");

        doc.getRootElement().addContent(file);
    }

    private void createUser(Document doc, String name, String homedir, String password, String mask) {

        Element user = new Element("user");
        user.addContent(new Element("username").setText(name));
        user.addContent(new Element("homedir").setText(homedir));
        user.addContent(new Element("password").setText(password));
        user.addContent(new Element("mask").setText(mask));
        System.out.println("createUser");
        doc.getRootElement().addContent(user);
    }
}