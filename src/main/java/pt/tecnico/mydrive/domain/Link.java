package pt.tecnico.mydrive.domain;

import java.util.List;

import pt.tecnico.mydrive.exception.UserIsNotInSessionException;

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
    	if (!u.isInSession()) {
			throw new UserIsNotInSessionException(u.getMyToken());
		}
    }

    
    @Override
    public String getType(){
    	return "Link";
    }
}
