package com.controller;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		/* 3 ways for creating an array */
		
		//Type 1 : giving values directly 
		int[] x= {1,4,2,7,6,9,3}; 
		
		//Type 2: we dont know the value just yet. they will come from DB later on
		 
		int[] y = new int[10];
		//y.length = 100; length of an array is final 
		for(int i=0;i<y.length;i++) {
			y[i] = i+1;
		}

		for(int i=0;i<y.length;i++) { //traditional for
			System.out.print(y[i] + " ");
		}
		
		//Type 3: combo of 1 of 2
		int[] z = new int[]{1,4,2,7,6,9,3};
		System.out.println("\n---------");
		for(int temp : z) { //extended for: for each 
			System.out.print(temp + " ");
		}
		
		/* Sorting of an Array */
		Arrays.sort(z);
		System.out.println("\n----Sorted array----");
		for(int temp : z) { //extended for: for each 
			System.out.print(temp + " ");
		}
		System.out.println("\n----Searching array----");
		/* Searching element in Array : BinarySearch*/
		System.out.println(Arrays.binarySearch(z, 6) >0?"found":"not found");
		System.out.println(Arrays.binarySearch(z, 5) >0?"found":"not found");
	}
}