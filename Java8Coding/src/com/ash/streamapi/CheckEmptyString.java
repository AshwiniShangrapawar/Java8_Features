package com.ash.streamapi;


	import java.util.Arrays;
	import java.util.List;
import java.util.stream.Collectors;

	public class CheckEmptyString {
	
	    public static void main(String[] args) {
	        List<String> strings = Arrays.asList("hello", "", "world", "", "example", "");

	        // Use Stream API to filter and find empty strings
	        List<String> emptyStrings = strings.stream()
	                                          .filter(s -> s.isEmpty()).collect(Collectors.toList());
	                                          //.toList();

	        // Print the found empty strings
	        System.out.println("Empty strings:");
	        emptyStrings.forEach(System.out::println);
	    }
	}


