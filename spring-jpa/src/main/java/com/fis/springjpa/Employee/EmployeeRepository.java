package com.fis.springjpa.Employee;

import org.springframework.data.repository.CrudRepository;



public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}