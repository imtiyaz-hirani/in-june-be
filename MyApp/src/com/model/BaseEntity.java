package com.model;

public abstract class BaseEntity {
	protected long id;
	
	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	} 
	
}
//final: when u have a common value for all object 
