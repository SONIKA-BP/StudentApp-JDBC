package com.StudentApp.dao;

import java.util.ArrayList;

import com.StudentApp.dto.Student;

public interface StudentDAOInterface {
	
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mail, String password);
	public Student getStudent(long phone, String mail);
	public ArrayList<Student> getStudent();
	public ArrayList<Student> getStudent(String name);

}
