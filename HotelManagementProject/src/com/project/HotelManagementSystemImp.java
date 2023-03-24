package com.project;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import exception.InvalidQuantityException;

public class HotelManagementSystemImp implements HotelManagementSystem {

	Scanner scanner=new  Scanner(System.in);
	Map<Integer, Food> map=new LinkedHashMap<Integer,Food>();
	Set<Integer> keys = map.keySet();//1,2,3,4,5 keys are stored

	int totalcost=0;

	@Override
	public void addFood() {
		// Entries
		map.put(1,new Food(1,"Chicken Biriyani",240,6));
		map.put(2,new Food(2,"Mashroom Biriyani",210,4));
		map.put(3,new Food(3,"Panner Biriyani",220,5));
		map.put(4,new Food(4,"Fish Biriyani",230,3));
		map.put(5,new Food(5,"Mutton Biriyani",260,7));
		System.out.println("Food Menu Created");
	}

	@Override
	public void displayFood() {
		for(int i :keys) {
			System.out.println("Enter "+i+"-->"+map.get(i));
		}
		System.out.println();
	}

	@Override
	public void orderFood() {
		// 1. get the food object based on id / choice -> get()
		// 2. Accept Quantity -> Set new Quantity
		// 3. Calculator cost
		// 4. cost -> Total Bill
		// 5. InvalidQuantityException

		//1.get the food object based on id/choice-->get()

		System.out.println("Order Your Food: \n");
		int id=scanner.nextInt();
		Food food=map.get(id);
		System.out.println("Ordering: "+food.getName()+"\n");

		// 2.Accept Quantity-->set new Quantity

		System.out.println();
		System.out.println("Select Quantity\n");
		int quantity=scanner.nextInt();

		if(quantity <=food.getQuantity()) {
			food.setQuantity(food.getQuantity()-quantity);

			// 3.Calculator Cost
			int currentcost=food.getCost()*quantity;

			//4.cost->total bill
			totalcost=totalcost + currentcost;
			System.out.println("ordered: "+quantity +" "+food.getName()+" at the cost of Rs."+currentcost+"\n");

		}
		else {
			try {
				throw new InvalidQuantityException("Sorry for the inconvenience, but that item is not yet ready Please wait some time."+food.getQuantity()+"\n");
			}
			catch(InvalidQuantityException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void checkOut() {
		if(totalcost !=0) {
			System.out.println("Total Bill:Rs. "+totalcost+"\n");

		}else {
			System.out.println("Please add some items to your cart.\n");;
		}

	}

}
