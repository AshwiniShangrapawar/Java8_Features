/*Assignment on Stream Api 

list = {1 ,2, 5, 25, 30, 5, 25}

1)find out duplicate elements from number of list
2)findout unique elemts from list
3)find even and odd number from list
4) find out prime number from list
5)square all the number from list
6)find the addition of all the number from list
*/
package com.ash.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayList {
	List<Integer> num = Arrays.asList(1,2,5,25,30,5,25);
	public static boolean isPrime(int x){
		int count = 0;
		for(int i=1 ; i<=x ; i++)
		{
			if(x % i == 0)
				count++;
		}
		return count ==2;
	}
	

	
	 public static void main(String[] args) {
		
	List<Integer> num = Arrays.asList(1,2,5,25,30,5,25);
	
	//Set is a feature which allows you to have only Unique Elements
	//so, from the num im going to get streams.
	//after getting a stream again going to use filter to filter out the stream
	//while filtering im going to target each element from the list as n
	//I'll try to add the element to the Hashset and if the addition is successful means it wasnt present in the hashset
	//& if the addition fails tht means it was already present in the hashset and it specifies tht this item it duplicate.
	System.out.println("Duplicate Elements are- ");
	Set<Integer> hs = new HashSet<Integer>();
	num.stream().filter(n ->!hs.add(n)).forEach(System.out::println);
	
	
	System.out.println("Unique Elements -");
	num.stream().distinct().forEach(x ->System.out.println(x));

	System.out.println("Even numbers");
	num.stream().filter(i -> i%2 ==0).forEach(x -> System.out.println(x));
	
	System.out.println("Odd Numbers");
	num.stream().filter(i -> i%2 !=0).forEach(System.out::println);
	
	System.out.println("Square of all Elements -");
	num.stream().map(i -> i*i).forEach(x -> System.out.println(x));

	//System.out.println("Square of all distinct Elements -");
	//num.stream().map(i -> i*i).distinct().forEach(x -> System.out.println(x));
	
	System.out.println("Prime Num - ");
	num.stream().filter(i -> isPrime(i)).forEach(x -> System.out.println(x));
	
	// Sort this list into Descending order
    num.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    
    // Addition of all the numbers from the list 
    System.out.println("Addition of all the numbers");
    Integer sum = num.stream().reduce(1, (a,b) -> a+b);
	
	System.out.println(sum);

	}
	}
