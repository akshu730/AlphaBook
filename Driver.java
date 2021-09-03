package com.jdbc.day3;

import java.util.Scanner;

public class Driver {
	
	public static void homePage()
	{
		SocialMedia sm = new SocialMedia();
		System.out.println("***********ALPHABOOK************");
		System.out.println("1 LOGIN");
		System.out.println("2.SIGNUP");
		System.out.println("3.EXIT");
		System.out.println();
		System.out.println("ENTER YOUR CHOICE");
		Scanner sc  = new Scanner(System.in);
		int ch = sc.nextInt();
		do
		{
			switch (ch) 
			{
				case 1: 
				{
					sm.login();
				}break;
				case 2:
				{
					sm.Signup();
				}break;
				case 3:
				{
					System.out.println("Thank you");
					System.exit(0);
				}break;
				default:
					System.out.println("Enter the correct choice");
			}
			
		}while(true);
	}

	public static void main(String[] args) 
	{	
		homePage();
	}

}
