package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		/* STEP 1: Create a handler */
		File file = new File("myfile.txt");
		
		FileReader reader = new FileReader(file);
		StringBuilder message = new StringBuilder(""); 
		int input; 
		while((input = reader.read()) != -1 ) {
			 message.append((char)input);
		}
		System.out.println(message);
		reader.close();
	}
}