package com.StudentApp.app;

import java.util.Scanner;

import com.StudentApp.dto.Student;
import com.StudentApp.dao.*;

public class SignUp {
	
	public static void signup() {
		StudentDAOInterface sdao=new StudentDAOImplementation();
		Student s=new Student();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the ID");
		s.setId(sc.nextInt());
		System.out.println("Enter the name");
		s.setName(sc.next());
		System.out.println("Enter the email");
		s.setEmail(sc.next());
		System.out.println("Enter the phone");
		s.setPhone(sc.nextLong());
		System.out.println("Enter the branch");
		s.setBranch(sc.next());
		System.out.println("Enter the password");
		String pass=sc.next();
		System.out.println("Enter the confirm password");
		String cpass=sc.next();
		if(pass.equals(cpass)) {
			s.setPassword(cpass);
			boolean res=sdao.insertStudent(s);
			if(res) {
				System.out.println("Data added successfully!");
			}
			else {
				System.out.println("Failed to add the data");
			}
		}
		else {
			System.out.println("Password NOT matched");
		}
		
	}

}
