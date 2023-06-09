package com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		map.put("harry", "potter");
		map.put("ronald", "weasley");
		map.put("hermione", "granger");
		
		System.out.println("Enter the username: ");
		String username = sc.next();
		boolean isLogin=false; 
		for(String key : map.keySet()) { //key:harry(loop) ; key:ronald(loop) ; key: hermione
			if(key.equals(username)) {
				System.out.println("Please enter password: ");
				String password = sc.next();
				String value = map.get(username);
				if(password.equals(value)) {
					System.out.println("Welcome " + username);
					System.out.println("login success!!!");
					isLogin=true;
					break;
				}
			}
		}
		if(isLogin == false) {
			System.out.println("Login denied");
		}
	}
}

/*
  list.add(obj) 
  map.put(key,value)
  key: username
  value: password
  
  
 */