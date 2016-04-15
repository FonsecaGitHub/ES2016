package pt.tecnico.mydrive.domain;

public class Link extends Link_Base {
    
    public Link() {
        super();
    }

    public Link(String content){
        super();
        this.setContent(content);
    }
    
    @Override
    public String getType(){
    	return "Link";
    }
}
