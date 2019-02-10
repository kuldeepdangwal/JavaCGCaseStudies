package com.cg.student.services;

import java.util.List;
import com.cg.student.beans.Student;
import com.cg.student.exceptions.StudentDetailsNotFoundException;

public interface StudentServices {
	public int acceptStudentDetails(String studentName, String studentAddress, long contactNumber, String studentClass,
			boolean transportStatus, int tutionFees, int examinationFees);
	
	int calculateTotalFees(int studentId)throws StudentDetailsNotFoundException;
	
	Student getStudentDetails(int studentId)throws StudentDetailsNotFoundException;
	
	List<Student> getAllStudentDetails();
}
