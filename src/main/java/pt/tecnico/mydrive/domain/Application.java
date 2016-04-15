package pt.tecnico.mydrive.domain;

public class Application extends Application_Base {
    
    public Application() {
        super();
    }

    public Application(String content){
        super();
        this.setContent(content);
    }
    
    @Override
    public String getType(){
    	return "Application";
    }
}
