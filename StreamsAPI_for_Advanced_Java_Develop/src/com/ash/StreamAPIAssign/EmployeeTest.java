package com.ash.StreamAPIAssign;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {
	public static void main(String[] args) {
		
	
	
	List<Employee> employeeList = Arrays.asList(
			new Employee(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0),
	new Employee(2, "Smith", 25, "Male", "Sales", 2015, 13500.0),
	new Employee(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0),
	new Employee(4, "Orlen", 28, "Male", "Development", 2014, 32500.0),
	new Employee(5, "Charles", 27, "Male", "HR", 2013, 22700.0),
	new Employee(6, "Cathy", 43, "Male", "Security", 2016, 10500.0),
	new Employee(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0),
	new Employee(8, "Suresh", 31, "Male", "Development", 2015, 34500.0),
	new Employee(9, "Gita", 24, "Female", "Sales", 2016, 11500.0),
	new Employee(10, "Mahesh", 38, "Male", "Security", 2015, 11000.5),
	new Employee(11, "Gouri", 27, "Female", "Infrastructure", 2014, 15700.0),
	new Employee(12, "Nithin", 25, "Male", "Development", 2016, 28200.0),
	new Employee(13, "Swathi", 27, "Female", "Finance", 2013, 21300.0),
	new Employee(14, "Buttler", 24, "Male", "Sales", 2017, 10700.5),
	new Employee(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.0),
    new Employee(16, "Sanvi", 26, "Female", "Development", 2015, 28900.0)
    );  

	//1. How many male and female employees are there in the organization ?
   Map<String, Long> noOfMaleandFemale = employeeList.stream()
		   .collect(Collectors.groupingBy(emp -> emp.gender,Collectors.counting()));
   System.out.println("No. of Male and Female are- "+noOfMaleandFemale);	
   
    // 2. Print the name of all departments in the organization ?
   employeeList.stream().map(s -> s.getDepartment()).distinct().forEach(p -> System.out.println(p));
   
   //3. What is the average age of male and female employees ?
   Map<String , Double> avgAge= employeeList.stream()
		   .collect(Collectors.groupingBy(emp -> emp.getGender(), Collectors.averagingInt( emp ->emp.getAge())));
   System.out.println("Average Age of Male & Female Employees -" +avgAge);
   
  
   //4. Get the details of highest paid employee in the organization
  Optional<Employee> highestPaidEmp = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(emp -> emp.getSalary())));
  
  if(highestPaidEmp.isPresent()) {
	  System.out.println("Highest Paid Employee in the Organization - "+highestPaidEmp.get());
  }
  
  
   //5. Get the names of all employees who have joined after 2015 
   employeeList.stream().filter(emp -> emp.getYearOfJoining() > 2015)
   .map(emp -> emp.getName()).forEach(name -> System.out.println(name));
   
   // 6. Count the number of employees in each department
   Map<String , Long> count=employeeList.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment(),Collectors.counting()));
   System.out.println("Counting -"+count);
  
   //7. What is the average salary of each department ?
  Map<String , Double> avgSalaryOfDept= employeeList.stream()
		  .collect(Collectors.groupingBy(emp -> emp.getDepartment(),Collectors.averagingDouble(emp -> emp.getSalary())));
  System.out.println("Average Salary Of Each Department -" +avgSalaryOfDept);
  
  
  //8. Get the Details of youngest male employee in the development department
  Optional<Employee> youngestMale = employeeList.stream().filter(emp -> emp.getGender()== "Male" && emp.getDepartment()=="Development")
		   .collect(Collectors.minBy(Comparator.comparing(emp -> emp.getAge())));
  System.out.println("Youngest Male Employee In the Devp dept. " +youngestMale);
  //OR
  Optional<Employee> youngestMale2 = employeeList.stream().filter(emp -> emp.gender.equals("Male") && emp.department.equals("Development"))
		   .min(Comparator.comparing(emp -> emp.getAge()));
  System.out.println("Youngest Male Employee In the Devp dept. " +youngestMale2.get()); // use .get() method to not get optionalin the op

  
  
  //9.  Who has the most working experience in the organization ?
  Optional<Employee> mostWorkExp = employeeList.stream().collect(Collectors.minBy(Comparator.comparing(s -> s.getYearOfJoining())));
  System.out.println("Most Working Employee in the Organization -" +mostWorkExp.get());
  
   //10. How many male and female employees are there in the Sales team 
   Map<String,Long> howmanyMF = employeeList.stream().filter(emp -> emp.getDepartment() == "Sales")
		   .collect(Collectors.groupingBy(emp -> emp.getGender(),Collectors.counting()));
   System.out.println(howmanyMF);	
   
   //11.  What is the average salary of male and female employees
    Map<String , Double> avgSalary = employeeList.stream().
		   collect(Collectors.groupingBy(emp -> emp.getGender() ,Collectors.averagingDouble(emp -> emp.getSalary())));
   System.out.println(" Average salary of Male & Female-" +avgSalary);
   
   //12 . List down the names of all employees in each department
   Map<String, List<Employee>> employeeListByDepartment=
		   employeeList.stream().collect(Collectors.groupingBy(emp -> emp.getDepartment()));
   System.out.println("Names of all employees in each department -" +employeeListByDepartment);
   
   //13. What is the average salary and total salary of the whole organization
    DoubleSummaryStatistics sumSalary= employeeList.stream().collect(Collectors.summarizingDouble(emp -> emp.salary));
    System.out.println("Avg and Total Salary - " +sumSalary);
    //Avg and Total Salary - DoubleSummaryStatistics{count=16, sum=323701.000000, min=10500.000000,
    //average=20231.312500, max=34500.000000}

    
   //14. Separate the Employees who r younger or equal to 25 years from those employees who r older than 25 years
      Map<Boolean, List<Employee>> youngOld= employeeList.stream().collect(Collectors.partitioningBy(emp -> emp.age > 25));
      System.out.println(youngOld);
      
      
   //15. Who is the oldest employee in the organization?
   Optional<Employee> oldestEmployee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(emp -> emp.getAge())));
  
   System.out.println("OLdest Employee in the Organization-" +oldestEmployee.get() );

}
}