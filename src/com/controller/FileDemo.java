package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		/* STEP 1: Create a handler */
		File file = new File("myfile.txt");
		
		if(file.createNewFile()) {
			System.out.println("file created");
		}
		
		
		/* Write the data into the file */
		PrintWriter pw = new PrintWriter(file);
		pw.println("Hey harry, how are you??");
		pw.println("This is auto email");
		pw.println("regards, Incedo");
		pw.close();
		
		System.out.println("thanx");
		
	}
}
