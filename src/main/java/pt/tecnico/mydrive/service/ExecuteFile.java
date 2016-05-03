package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import pt.tecnico.mydrive.domain.*;


public class ExecuteFile extends MyDriveService{

	private long userToken;	
	private String path;
	private List<String> args;

	public ExecuteFile(long userToken, String path, List<String> args) {
		this.userToken = userToken;
		this.path = path;
		this.args = args;	
	}

	
	@Override
	protected void dispatch() throws MyDriveException {
		args = new ArrayList<String>();
		// para app files
		Class<?> cls;
		Method meth;
		try { // name is a class: call main()
			cls = Class.forName(name);
			meth = cls.getMethod("main", String[].class);
		} catch (ClassNotFoundException cnfe) { // name is a method
			int pos;
			if ((pos = name.lastIndexOf('.')) < 0)
				throw cnfe;
			cls = Class.forName(name.substring(0, pos));
			meth = cls.getMethod(name.substring(pos + 1), String[].class);
		}
		meth.invoke(null, (Object) args); // static method (ignore return)

	}
}