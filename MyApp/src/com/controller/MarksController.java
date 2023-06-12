package com.controller;

import com.exception.IllegalMarksException;
import com.service.MarksService;

public class MarksController {
	public static void main(String[] args) {
		MarksService service = new MarksService();
		double marks_scored= 301;
		double total_marks = 300;
 		try {
			String grade = service.compute(marks_scored,total_marks);
			System.out.println("Your grade is " + grade);
		} catch (IllegalMarksException e) {
			System.out.println(e.getMessage());
		}
		 
	}
}