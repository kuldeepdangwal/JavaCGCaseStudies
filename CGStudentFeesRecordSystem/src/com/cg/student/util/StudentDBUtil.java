package com.cg.student.util;

import java.util.HashMap;

import com.cg.student.beans.Student;

public class StudentDBUtil {
	public static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	
	private static int STUDENT_ID_COUNTER=0;
	
	public static int getSTUDENT_ID_COUNTER() {
		return ++STUDENT_ID_COUNTER;
	}
}
