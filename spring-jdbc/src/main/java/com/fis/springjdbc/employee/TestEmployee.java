package com.fis.springjdbc.employee;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("daoexample.xml");
		EmployeeDAOImpl bean = context.getBean("employeeDao", EmployeeDAOImpl.class);
		System.out.println("===============================");
		System.out.println("Insert a Product");
		Employee newEmployee = new Employee();
		newEmployee.setId(30);
		newEmployee.setName("eraser");
		bean.insertEmployee(newEmployee);
		System.out.println("===============================");
		System.out.println("Delete Product");
		int id = 10;
		bean.deleteEmployee(id);
		System.out.println("===============================");
		System.out.println("Get Product Based on Id");
		id = 20;
		Employee employeeById = bean.getEmployeeById(id);
		System.out.println(employeeById);
		System.out.println("===============================");
		System.out.println("Update Product");
		newEmployee = new Employee();
		newEmployee.setId(30);
		newEmployee.setName("browneraser");
		bean.updateEmployee(newEmployee);
		System.out.println("===============================");
		System.out.println("Get All Products");
		System.out.println(bean.getAllEmployees());
		System.out.println("===============================");

		context.close();
	}
}
