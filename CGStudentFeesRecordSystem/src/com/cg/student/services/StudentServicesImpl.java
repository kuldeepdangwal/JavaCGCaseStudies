package com.cg.student.services;

import java.util.List;

import com.cg.student.beans.Fees;
import com.cg.student.beans.Student;
import com.cg.student.daoservices.StudentDAO;
import com.cg.student.daoservices.StudentDAOImpl;
import com.cg.student.exceptions.StudentDetailsNotFoundException;

public class StudentServicesImpl implements StudentServices{
	
	private StudentDAO studentDao = new StudentDAOImpl();

	@Override
	public int acceptStudentDetails(String studentName, String studentAddress, long contactNumber, String studentClass,
			boolean transportStatus, int tutionFees, int examinationFees) {
		Student student = new Student(studentName, studentAddress, contactNumber, studentClass, transportStatus, new Fees(tutionFees, examinationFees));
		student = studentDao.save(student);
		return student.getStudentId();
	}

	@Override
	public int calculateTotalFees(int studentId) throws StudentDetailsNotFoundException {
		Student student = getStudentDetails(studentId);
		int totalFees=0;
		if(student.isTransportStatus()==false)
			student.getFees().setTransportFees(0);
		else
			student.getFees().setTransportFees(1000);
		
		totalFees = student.getFees().getTutionFees()+student.getFees().getExaminationFees()+student.getFees().getTransportFees();
		
		return totalFees;
	}
	
	@Override
	public Student getStudentDetails(int studentId) throws StudentDetailsNotFoundException {
		Student student = studentDao.findOne(studentId);
		if(student==null)
			throw new StudentDetailsNotFoundException("Student Details not found for id = "+ studentId);
		
		return student;
	}

	@Override
	public List<Student> getAllStudentDetails() {
		return studentDao.findAll();
	}
}