package com.cg.student.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.student.beans.Fees;
import com.cg.student.beans.Student;
import com.cg.student.exceptions.StudentDetailsNotFoundException;
import com.cg.student.services.StudentServices;
import com.cg.student.services.StudentServicesImpl;
import com.cg.student.util.StudentDBUtil;

public class StudentFeesRecordTest {
	private static StudentServices services;

	@BeforeClass
	public static void setUpTestEnv() {
		services = new StudentServicesImpl();
	}

	@Before
	public void setUpTestData() {
		Student student1 = new Student(101,"Kuldeep", "ABC6754", 854796321, "9", false, new Fees(13000, 2500));
		Student student2 = new Student(102,"Amit Tandon", "KGF6754", 89856785, "8", true, new Fees(13500, 3000));

		StudentDBUtil.students.put(student1.getStudentId(), student1);
		StudentDBUtil.students.put(student2.getStudentId(), student2);

		StudentDBUtil.STUDENT_ID_COUNTER = 102;	
	}

	@Test(expected=StudentDetailsNotFoundException.class)
	public void testGetStudentDetailsForInvalidStudentId() throws StudentDetailsNotFoundException{
		services.getStudentDetails(123);
	}

	@Test
	public void testGetStudentDetailsForValidStudentId() throws StudentDetailsNotFoundException{
		Student expectedStudent = new Student(103,"Suresh Sharma", "TGIM6754", 987456321, "9", true, new Fees(15000, 3500));
		Student actualStudent = services.getStudentDetails(103);
		Assert.assertEquals(expectedStudent, actualStudent);
	}

	@Test(expected=StudentDetailsNotFoundException.class)
	public void testCalculateTotalFeesForInvalidStudentId() throws StudentDetailsNotFoundException{
		services.calculateTotalFees(123);
	}

	@Test
	public void testCalculateTotalFeesForValidStudentId() throws StudentDetailsNotFoundException{
		int expectedTotalFees  = 17500;
		int actualTotalFees = services.calculateTotalFees(102);
		Assert.assertEquals(expectedTotalFees, actualTotalFees);
	}
	
	@Test
	public void testGetAllStudentDetails() {
		Student student1 = new Student(101,"Kuldeep", "ABC6754", 854796321, "9", false, new Fees(13000, 2500));
		Student student2 = new Student(102,"Amit Tandon", "KGF6754", 89856785, "8", true, new Fees(13500, 3000));
		
		ArrayList< Student> expectedStudentList = new ArrayList<Student>();
		expectedStudentList.add(student1);
		expectedStudentList.add(student2);
		ArrayList<Student> actualStudentList = new ArrayList<Student>();
		Assert.assertEquals(expectedStudentList, actualStudentList);	
	}

	@After
	public void tearDownTestData() {
		StudentDBUtil.students.clear();
		StudentDBUtil.STUDENT_ID_COUNTER=100;
	}

	@AfterClass
	public static void tearDownTestEnv() {
		services = null;
	}
}
