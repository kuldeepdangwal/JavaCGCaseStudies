package com.cg.student.daoservices;

import java.util.ArrayList;
import java.util.List;

import com.cg.student.beans.Student;
import com.cg.student.util.StudentDBUtil;

public class StudentDAOImpl implements StudentDAO{
	
	@Override
	public Student save(Student student) {
		student.setStudentId(StudentDBUtil.getSTUDENT_ID_COUNTER());
		StudentDBUtil.students.put(student.getStudentId(), student);
		return student;
	}

	@Override
	public boolean update(Student student) {
		return false;
	}

	@Override
	public Student findOne(int studentId) {
		return StudentDBUtil.students.get(studentId);
	}

	@Override
	public List<Student> findAll() {
		return new ArrayList<Student>(StudentDBUtil.students.values());
	}
}
