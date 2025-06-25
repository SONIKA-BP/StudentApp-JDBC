package com.StudentApp.app;

import java.util.Scanner;

public class index {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("------------WELCOME TO STUDENT APP------------");
			System.out.println("1. SignUP");
			System.out.println("2. LogIn");
			System.out.println("3. Forgot password");
			System.out.println("4. Exit");
			choice=sc.nextInt();
			switch(choice) {
			case 1: SignUp.signup();
			break;
			case 2: Login.login();
			break;
			case 3: ForgotPassword.forgotPassword();
			break;
			case 4: System.out.println("Thank you!");
			break;
			default: System.out.println("Invalid choice");
			break;
			}
		}while(choice!=4);
	}
}
	