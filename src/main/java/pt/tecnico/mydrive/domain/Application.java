package pt.tecnico.mydrive.domain;

public class Application extends Application_Base {
    
    public Application() {
        super();
    }
    
    @Override
    public void printType(){
    	super.printType();
    	System.out.println("Application");
    }
}
