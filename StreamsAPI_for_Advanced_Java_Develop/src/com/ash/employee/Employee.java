package com.ash.employee;

public class Employee {
	String empName;
	int age;
	
	public Employee(String empName, int age) {
		
		this.empName = empName;
		this.age = age;
	
	
	}
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", age=" + age + "]";
	}
	

}
