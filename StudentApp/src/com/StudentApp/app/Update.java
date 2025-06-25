package com.StudentApp.app;
import java.util.Scanner;

import com.StudentApp.dao.*;
import com.StudentApp.dto.Student;

public class Update {
	public static void update(Student s) {
		Scanner sc=new Scanner(System.in);
	
		boolean status=false;
		StudentDAOInterface sdao=new StudentDAOImplementation();
		int choice=0;
		do {
			System.out.println("which field u want to update");
			System.out.println("1. ID");
			System.out.println("2. Name");
			System.out.println("3. Email");
			System.out.println("4. Phone");
			System.out.println("5. Branch");
			System.out.println("6. Password");
			System.out.println("7. Back");
			choice=sc.nextInt();
			switch(choice) {
			case 1:System.out.println("Enter the ID"); 
				s.setId(sc.nextInt());
			break;
			
			case 2:System.out.println("Enter the Name"); 
				s.setName(sc.next());
			break;
			
			case 3:System.out.println("Enter the Email"); 
				s.setEmail(sc.next());
			break;
			
			case 4:System.out.println("Enter the Phone"); 
				s.setPhone(sc.nextLong());
			break;
			
			case 5:System.out.println("Enter the Branch"); 
				s.setBranch(sc.next());
			break;
			
			case 6:System.out.println("Enter the Password"); 
				s.setPassword(sc.next());
			break;
			
			case 7: System.out.println("Back............");
			break;
			
			default:
				System.out.println("Please enter valid choice");
				break;
				
			}
			
			status=sdao.updateStudent(s);
			if(status) {
				System.out.println("Data updated successfully!");
			}
			else {
				System.out.println("Failed to update the data!");
			}
		}while(choice!=7);
		
	}

}
