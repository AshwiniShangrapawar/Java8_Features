package com.ash.streamapi;

import java.util.function.Predicate;

public class NameWithD {

	public static void main(String[] args) {
		
		String names[] = {"David", "Ashu", "Ashima","Dhanashree","Divya","Sakshi"};
	//	Predicate<String> p = (name) -> name.charAt(0) == "D";
		Predicate<String> p = (name) -> name.startsWith("D");
        for(String s : names) {
        	if(p.test(s)) {
         System.out.println(s);
        	}
	}
	}
}
