package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.exception.*;
import pt.tecnico.mydrive.domain.*;


public class CreateDir {
	private int id;
	private String name;
	
	public int getDirId() {
		return this.id;
	}
	
	public CreateDir(String name) {
		this.name = name;
	}
	
	/*@Override
	protected void dispatch() {
		getMydrive().addDir(...)
	}*/
	
}