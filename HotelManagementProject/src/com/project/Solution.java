package com.project;

import java.util.Scanner;

import exception.InvalidChoiceException;

public class Solution {
	public static void main(String[]args) {
		System.out.println("Welcome To 7thHeaven Hotel");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		
		int input=1;
		Scanner scanner=new Scanner(System.in);
		HotelManagementSystem hotel=new HotelManagementSystemImp();//upcasting
		hotel.addFood();//adding the all menu
		
		while(input==1) {
			System.out.println("1.Add Food\n2.Check Out\nPlease Select Your Choice");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1 :{
				hotel.displayFood();
				hotel.orderFood();
				break;
			}
			case 2 : {
				hotel.checkOut();
			}
			default : {
				try {
					throw new InvalidChoiceException("Invalid Choice!,Enter Current Choice\n");
					
				}
				catch(InvalidChoiceException e) {
					System.out.println(e.getMessage());
				}
			}
			}//end switch
			System.out.println("Enter 1 to order other dishes any other number to exit");
			input=scanner.nextInt();
			System.out.println("--------------------------");
		}//end while
		hotel.checkOut();
		System.out.println("Thank You....!\n Visit Again");
		System.exit(0);
	}

}
