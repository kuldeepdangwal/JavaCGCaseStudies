package com.cg.employee.services;

import java.util.List;

import com.cg.employee.beans.Employee;
import com.cg.employee.exceptions.EmployeeDetailsNotFoundException;

public interface EmployeeServices {
	int acceptEmployeeDetails(String empName, String empAddress, long contactNumber, String designation, int deptId, String deptName);
	
	Employee getEmployeeDetails(int empId) throws EmployeeDetailsNotFoundException;
	
	List<Employee> getAllEmployeeDetails();
}
