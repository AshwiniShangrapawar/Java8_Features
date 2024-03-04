package com.ash.Salaryby10cent;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(26,"Ashwini",30000);
		Employee e2 = new Employee(36,"Ashima",30500);
		Employee e3 = new Employee(18,"Amisha",13300);
		Employee e4 = new Employee(29,"Ankita",76600);
		Employee e5 = new Employee(19,"Apec",10000);
		
		List<Employee> emp = Arrays.asList(e1,e2,e3,e4,e5);
		
		//Increase the Salary of Each Employee , whose age > 25 by 10%
		
		List<Employee> increasedSalary = emp.stream().map(e ->
		{
		if(e.getAge() > 25) {
			e.setSalary(e.getSalary()*1.10);
		}
		return e;
		}).collect(Collectors.toList());
		
		System.out.println(increasedSalary);
		
		// if salary is > 30000 give bonus of 40%
		//else give bonus of 10 % only
		
		Function<Employee, Integer> fn = e->{
			double sal = e.salary;
			if(sal > 30000)
				return (int) (sal*40/100);
			else
				return (int) (sal*10/100);
			};
			for(Employee em : emp) {
				double bonus = fn.apply(em);
				System.out.println(em.name+ " " +em.salary);
				System.out.println("Bonus is : " +bonus);
			}
		
		
	}
}
