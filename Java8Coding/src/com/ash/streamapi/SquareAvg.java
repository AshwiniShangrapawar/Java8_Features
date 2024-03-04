package com.ash.streamapi;

import java.util.Arrays;
import java.util.List;

//square of each and every number then u have to filter itout on the basis of ....if a num is greater than 100 thn u have to pick it
//then do the avg of these picked numbers
public class SquareAvg {
public static void main(String[] args) {
	
	List<Integer> list =  Arrays.asList(1,10,20,30,15);
	double avg = list.stream()
	   .map(e -> e*e)  //get each nd every element from the arraylist and then dothe multiplication
	      .filter(e -> e>100) // before conversion to integers , need to filter out the elements which is > 100
	         .mapToInt(e -> e)    // do conversion of map into integers once again
                .average().getAsDouble();

	System.out.println(avg);

}
}