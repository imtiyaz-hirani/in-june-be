package com.persistence;

public abstract interface BaseRepository {
	public default void dbConnect() {
		System.out.println("dbConnect");
	}
	
	public default void dbClose() {
		System.out.println("dbClose");
	}
	
	public abstract void save();
	public abstract void delete();
	public void getAll();
	public void getOne();
	public void put();
}

//Spring has already done it for us. : JpaRepository / CrudRepository 