package org.baristamatic.dispensary;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BaristamaticMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Inventory inven = new Inventory();
		inven.displayInventory();
		inven.displayMenu();
		Map<Integer, String> inpToDrinkMap = new LinkedHashMap<>();
		inpToDrinkMap.put(1, "Caffe Americano");
		inpToDrinkMap.put(2, "Caffe Latte");
		inpToDrinkMap.put(3, "Caffe Mocha");
		inpToDrinkMap.put(4, "Cappuccino");
		inpToDrinkMap.put(5, "Coffee");
		inpToDrinkMap.put(6, "Decaf Coffee");
		
		System.out.println("Please enter your option:");
		Map<String, Drink> drinks = inven.getDrinksMap();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			
			String ch = sc.nextLine();
			
			if(ch.equalsIgnoreCase("q")){
				return;
			}
			else if(ch.equalsIgnoreCase("r")){
				inven.reStockInventory();
			}
			else if(Integer.parseInt(ch)>0 && Integer.parseInt(ch)<7){
				Integer option = Integer.parseInt(ch);
				if(inven.checkIngredientAvailability(drinks.get(inpToDrinkMap.get(option)))){
					System.out.println("Dispensing: "+ inpToDrinkMap.get(option));
				}else{
					System.out.println("Out of stock: "+ inpToDrinkMap.get(option));
				}
				inven.Dispense(drinks.get(inpToDrinkMap.get(option)));
				 
			}
			else{
				System.out.println("Invalid selection: <characters that were entered>");
			}
			inven.displayInventory();
			inven.displayMenu();
		}
		
		
	}

}
