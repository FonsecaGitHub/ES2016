package pt.tecnico.mydrive.domain;

import java.util.List;

public class Link extends Link_Base {
    
    public Link() {
        super();
    }

    public Link(String content){
        super();
        this.setContent(content);
    }
    
    
    @Override
    public void execute(User u, List<String> args){
    	
    }

    
    @Override
    public String getType(){
    	return "Link";
    }
}
