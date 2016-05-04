package pt.tecnico.mydrive.domain;

import java.util.List;

public class Application extends Application_Base {
    
    public Application() {
        super();
    }

    public Application(String content){
        super();
        this.setContent(content);
    }
    
    
    @Override
    public void execute(User u, List<String> args){
    	
    }

    
    @Override
    public String getType(){
    	return "Application";
    }
}
