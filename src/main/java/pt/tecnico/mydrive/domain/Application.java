package pt.tecnico.mydrive.domain;

import java.util.List;

import pt.tecnico.mydrive.exception.UserIsNotInSessionException;

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
    	if (!u.isInSession()) {
			throw new UserIsNotInSessionException(u.getMyToken());
		}/*
    	 Class<?> cls;
    	    Method meth;
    	    try { // name is a class: call main()
    	      cls = Class.forName(name);
    	      meth = cls.getMethod("main", String[].class);
    	    } catch (ClassNotFoundException cnfe) { // name is a method
    	      int pos;
    	      if ((pos = name.lastIndexOf('.')) < 0) throw cnfe;
    	      cls = Class.forName(name.substring(0, pos));
    	      meth = cls.getMethod(name.substring(pos+1), String[].class);
    	    }
    	    meth.invoke(null, (Object)args); // static method (ignore return)
    	  }*/
    }

    
    @Override
    public String getType(){
    	return "Application";
    }
}
