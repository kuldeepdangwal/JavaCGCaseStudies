package com.cg.student.daoservices;

import java.util.List;
import com.cg.student.beans.Student;

public interface StudentDAO {
	Student save(Student student);
	boolean update(Student student);
	Student findOne(int studentId);
	List<Student> findAll();
}
