package pt.tecnico.mydrive.domain;

public class Link extends Link_Base {
    
    public Link() {
        super();
    }
    
    @Override
    public String getType(){
    	return super.getType() +"Link";
    }
}
