package pt.tecnico.mydrive.domain;

public class Application extends Application_Base {
    
    public Application() {
        super();
    }
    
    @Override
    public String getType(){
    	return super.getType() +"Application";
    }
}
