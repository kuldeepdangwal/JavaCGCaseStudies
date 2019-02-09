package com.cg.employee.daoservices;
import java.util.List;
import com.cg.employee.beans.Employee;
public interface EmployeeDAO{
	Employee save(Employee employee);
	boolean update(Employee employee);
	Employee findOne(long empId);
	List<Employee> findAll();
}
