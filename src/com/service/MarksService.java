package com.service;

import com.exception.IllegalMarksException;

public class MarksService {

	public String compute(double marks_scored, double total_marks) throws IllegalMarksException{
		
		if(marks_scored < 0)	
			throw new IllegalMarksException("marks cannot be < 0");
		if(marks_scored > total_marks)
			throw new IllegalMarksException("marks cannot be > total_marks");
		
		double percent = (marks_scored / total_marks) * 100; 
		 
		return percent>75?"A":percent>60?"B":"C";
	}

}
