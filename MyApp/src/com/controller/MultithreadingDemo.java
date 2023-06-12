package com.controller;

import com.service.ThreadService;

public class MultithreadingDemo {
	public static void main(String[] args) throws InterruptedException { //main
		/* to create a thread we can use Thread class */
		
		//My Custom thread
		Thread t1 = new Thread(new ThreadUtil(),"MyThread-1");
		t1.start();
		
		//My Custom thread
		Thread t2 = new Thread(new ThreadUtil2(),"MyThread-2");
		t2.start();
				
		t1.join(); //we are asking JVM(thread: main) to join t1
		t2.join();//we are asking JVM(thread: main) to join t2
		
		
		//My Custom thread
		Thread t3 = new Thread(new ThreadUtil3(),"MyThread-3");
		t3.start();
		
		//My Custom thread
		Thread t4 = new Thread(new ThreadUtil4(),"MyThread-4");
		t4.start();
		t3.join();
		t4.join();
		System.out.println("\n thank you!!!");
	}
}

class ThreadUtil extends Thread{
	@Override
	public void run() {
		// give your task
		ThreadService.displayNumbers(10); 
	}
}

class ThreadUtil2 implements Runnable{

	@Override
	public void run() {
		// give your task
		ThreadService.countSum(1000); 
	}
	
}

class ThreadUtil3 implements Runnable{

	@Override
	public void run() {
		// give your task
		ThreadService.display(0, 500);
	}
	
}

class ThreadUtil4 implements Runnable{

	@Override
	public void run() {
		// give your task
		ThreadService.display(500, 1001);
	}
	
}
/* 
 THread class has 2 notable methods:
 1. start() - used to start the thread
 2. run() - called from start, and executes the task   
 
 Note: do not override start(), dont even worry about it. 
 Override run() method and give the work
 */