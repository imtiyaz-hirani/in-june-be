package com.service;

public class ThreadService {
	static int count =0;
	public static void displayNumbers(int num) {
		System.out.println("Executed by " + Thread.currentThread().getName() + "\n");
		for(int i=0;i<num;i++) {
			System.out.print(i + " - ");
		}
	}
	
	
	public static void countSum(int num) {
		System.out.println("Executed by " + Thread.currentThread().getName() + "\n");
		int sum = 0; 
		for(int i=1;i<=num;i++) {
			sum = sum + i;
		}
		System.out.println("Total Sum is " + sum);
	}
	
	public static void display(int start,int end) {
		synchronized("") {
			for(int i=start;i<end;i++) {
				System.out.println(Thread.currentThread().getName() + "---" + "send mail---" + count++);
			}
		}
		
	}
}