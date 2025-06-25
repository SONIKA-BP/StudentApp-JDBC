package com.StudentApp.app;

import com.StudentApp.dto.Student;

import java.util.ArrayList;
import java.util.Scanner;

import com.StudentApp.dao.*;

public class Login {
	public static void login() {
		StudentDAOInterface sdao=new StudentDAOImplementation();
		Student s;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the mail");
		String mail=sc.next();
		System.out.println("Enter the password");
		String password=sc.next();
		s=sdao.getStudent(mail,password);
		int choice=0;
		if(s!=null) {
			System.out.println("LogIN successfull! Hello "+s.getName());
			do {
				System.out.println("1. View Account");
				System.out.println("2. Update account");
				System.out.println("3. Search user");
				System.out.println("4. Main menu");
				if(s.getId()==1) {
					System.out.println("5. View all user");
					System.out.println("6. Delete user");
				}
				choice=sc.nextInt();
				switch(choice) {
				case 1: System.out.println(s);
				break;
				case 2: Update.update(s);
				break;
				case 3: System.out.println("Enter the student name to be search");
				String name=sc.next();
				ArrayList<Student> matchedList=sdao.getStudent(name);
				
				if(matchedList.isEmpty()) {
					System.out.println("OOPS! No student found with the name "+name);
				}
				else {
					System.out.println("Student found!");
					for(Student s2:matchedList) {
						System.out.println(s2);
							}
				}
					
					break;
				case 4: 
					System.out.println("Back to main menu.......");
					break;
				case 5: ArrayList<Student> studentList=sdao.getStudent();
				for(Student s1:studentList) {
					System.out.println(s1);
				}
				break;
				case 6:System.out.println("Enter the id to be deleted");
				s.setId(sc.nextInt());
				
				boolean res=sdao.deleteStudent(s);
				if(res) {
					System.out.println("Record deleted successfully");
				}
				else {
					System.out.println("Failed to delete the record");
				}
				break;
				default:
					System.out.println("Invalid choice");
					break;
				
				}
			}while(choice!=4);
			
		}
		else {
			System.out.println("Failed to login");
		}
		
	}

}
