package com.model;

public abstract class College extends BaseEntity{
	//id comes from BaseEntity as it is protected 
	protected final String cname="ACS Institute of Tech";
	
	public String getCname() {
		return cname;
	}
	/* Whoever extends this, must implement this,..*/
	public abstract void doTask();
}
/* 
  since doTask() does not have a body, I am making it as abstract. 
  abstract methods can only be written in abstract classes. 
 */