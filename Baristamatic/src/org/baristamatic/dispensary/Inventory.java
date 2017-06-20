package org.baristamatic.dispensary;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {
	
	private Map<Ingredient, Integer> inventory = new LinkedHashMap<Ingredient, Integer>();
	private Map<String, Drink> drinks = new LinkedHashMap<String, Drink>();
	
	public Inventory(){
		reStockInventory();
		buildMenu();
	}
	
	public void reStockInventory(){		
		inventory.put(new Ingredient("Cocoa", 0.90), 10);
		inventory.put(new Ingredient("Coffee", 0.75), 10);
		inventory.put(new Ingredient("Cream", 0.25), 10);
		inventory.put(new Ingredient("Decaf Coffee", 0.75), 10);
		inventory.put(new Ingredient("Espresso", 1.10), 10);
		inventory.put(new Ingredient("Foamed Milk", 0.35), 10);
		inventory.put(new Ingredient("Steamed Milk", 0.35), 10);
		inventory.put(new Ingredient("Sugar", 0.25), 10);
		inventory.put(new Ingredient("Whipped Cream", 1.00), 10);
	}
	
	public void buildMenu(){
		Map<Ingredient, Integer> caffeAmericanoIngredients = new HashMap<>();
		caffeAmericanoIngredients.put(new Ingredient("Espresso", 1.10), 3);
		Drink caffeAmericano = new Drink("Caffe Americano", caffeAmericanoIngredients);
		drinks.put("Caffe Americano", caffeAmericano);
		
		Map<Ingredient, Integer> caffeLatteIngredients = new HashMap<>();
		caffeLatteIngredients.put(new Ingredient("Espresso", 1.10), 2);
		caffeLatteIngredients.put(new Ingredient("Steamed Milk", 0.35), 1);
		Drink caffeLatte = new Drink("Caffe Latte", caffeLatteIngredients);
		drinks.put("Caffe Latte", caffeLatte);
		

		Map<Ingredient, Integer> caffeMochaIngredients = new HashMap<>();
		caffeMochaIngredients.put(new Ingredient("Espresso", 1.10), 1);
		caffeMochaIngredients.put(new Ingredient("Cocoa", 0.90), 1);
		caffeMochaIngredients.put(new Ingredient("Steamed Milk", 0.35), 1);
		caffeMochaIngredients.put(new Ingredient("Whipped Cream", 1.00), 1);
		Drink caffeMocha = new Drink("Caffe Mocha", caffeMochaIngredients);
		drinks.put("Caffe Mocha", caffeMocha);
	

		Map<Ingredient, Integer> cappuccinoIngredients = new HashMap<>();
		cappuccinoIngredients.put(new Ingredient("Espresso", 1.10), 2);
		cappuccinoIngredients.put(new Ingredient("Steamed Milk", 0.35), 1);
		cappuccinoIngredients.put(new Ingredient("Foamed Milk", 0.35), 1);
		Drink cappuccino = new Drink("Cappuccino", cappuccinoIngredients);
		drinks.put("Cappuccino", cappuccino);
		
		Map<Ingredient, Integer> coffeeIngredients = new HashMap<>();
		coffeeIngredients.put(new Ingredient("Coffee", 0.75), 3);
		coffeeIngredients.put(new Ingredient("Sugar", 0.25), 1);
		coffeeIngredients.put(new Ingredient("Cream", 0.25), 1);
		Drink coffee = new Drink("Coffee", coffeeIngredients);
		drinks.put("Coffee", coffee);
		
		Map<Ingredient, Integer> decafCoffeeIngredients = new HashMap<>();
		decafCoffeeIngredients.put(new Ingredient("Decaf Coffee", 0.75), 3);
		decafCoffeeIngredients.put(new Ingredient("Sugar", 0.25), 1);
		decafCoffeeIngredients.put(new Ingredient("Cream", 0.25), 1);
		Drink decafCoffee = new Drink("Decaf Coffee", decafCoffeeIngredients);
		drinks.put("Decaf Coffee", decafCoffee);
		
	}
	
	public void displayMenu(){
		System.out.println("Menu:");
		int i=0;
		for(String d: drinks.keySet()){
			double cost = drinks.get(d).calculateCost();
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println(++i + "," + d + "," + df.format(cost)+","+checkIngredientAvailability(drinks.get(d)));
		}
	}
	
	public boolean checkIngredientAvailability(Drink d){
		Map<Ingredient, Integer> ingredients = d.getIngredients();
		for(Ingredient i : ingredients.keySet()){
			if(ingredients.get(i)> inventory.get(i)){
				return false;
			}
		}
		return true;
	}
	
	public void displayInventory(){
		System.out.println("Inventory");
		for(Ingredient i : inventory.keySet()){
			System.out.println(i.getName() + "," + inventory.get(i));
		}
	}
	
	public boolean Dispense(Drink d){
		if(checkIngredientAvailability(d)){
			Map<Ingredient, Integer> ingredients = d.getIngredients();
			for(Ingredient i : ingredients.keySet()){
				int initialVal = inventory.get(i);
				initialVal -= ingredients.get(i);
				inventory.put(i, initialVal);
			}
			return true;
		}else{
			return false;
		}
	}
	
	public Map<String, Drink> getDrinksMap(){
		return drinks;
	}

}
