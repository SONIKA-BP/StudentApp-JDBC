package com.StudentApp.app;
import java.util.Scanner;

import com.StudentApp.dao.*;
import com.StudentApp.dto.Student;

public class ForgotPassword {
	public static void forgotPassword() {
		StudentDAOInterface sdao=new StudentDAOImplementation();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the registered Phone number");
		long regPhone=sc.nextLong();
		System.out.println("Enter the registered Email");
		String regEmail=sc.next();
		Student s=sdao.getStudent(regPhone, regEmail);
		if(s!=null) {
			System.out.println("Enter the new password");
			String newPass=sc.next();
			System.out.println("Enter the confirm password");
			String cPass=sc.next();
			if(newPass.equals(cPass)) {
				s.setPassword(cPass);
				boolean res=sdao.updateStudent(s);
				if(res) {
					System.out.println("Password updated successfully!");
				}
				else {
					System.out.println("Failed to update the password");
				}
			}
			else {
				System.out.println("Password mismatch, Try again!");
			}
		}
		else {
			System.out.println("Sorry!, No Student found");
		}
	}

}
