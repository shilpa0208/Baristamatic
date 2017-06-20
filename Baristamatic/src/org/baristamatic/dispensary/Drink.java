package org.baristamatic.dispensary;

import java.util.HashMap;
import java.util.Map;

public class Drink {

	private Map<Ingredient, Integer> ingredients = new HashMap<Ingredient,Integer>();
	
	private String drinkName;
	
	public Drink(String drinkName, Map<Ingredient, Integer> ingredients){
		this.drinkName = drinkName;
		this.ingredients = ingredients;
	}
	
	public Map<Ingredient, Integer> getIngredients(){
		return ingredients;
	}
	
	public double calculateCost(){
		double cost = 0.0;
		for(Ingredient i : ingredients.keySet()){
			cost +=(i.getCost()*ingredients.get(i));
		}
		return cost;
	}

	public String getDrinkName() {
		return drinkName;
	}

}
