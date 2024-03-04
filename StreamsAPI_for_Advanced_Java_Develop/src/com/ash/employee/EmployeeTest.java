package com.ash.employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EmployeeTest {
	public static void main(String[] args) {
		
	List<Employee> empList = Arrays.asList(
			new Employee("Amit",25),
			new Employee("Amit",30),
			new Employee("Ravi",30),
			new Employee("Priyanka",24)
			);
	
	 Map<String , Integer> rs= empList.stream()
			 .collect( Collectors.groupingBy(emp -> emp.getEmpName() ,Collectors.summingInt(emp -> emp.getAge())));
	System.out.println(rs);
	}

}
 