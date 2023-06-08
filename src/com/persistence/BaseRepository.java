package com.persistence;

public abstract interface BaseRepository {
	public default void dbConnect() {
		System.out.println("dbConnect");
	}
	
	public default void dbClose() {
		System.out.println("dbClose");
	}
	
	 
}

//Spring has already done it for us. : JpaRepository / CrudRepository 