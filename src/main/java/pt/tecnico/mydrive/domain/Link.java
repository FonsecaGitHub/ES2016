package pt.tecnico.mydrive.domain;

public class Link extends Link_Base {
    
    public Link() {
        super();
    }
    
    @Override
    public void printType(){
    	super.printType();
    	System.out.println("Link");
    }
}
