package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class RemoveDir {
	private int id;
	private String name;
	
	public int getDirId() {
		return this.id;
	}
	
	public RemoveDir(String name) {
		this.name = name;
	}
	
	/*@Override
	protected void dispatch() {
		getMydrive().addDir(...)
	}*/
	
}