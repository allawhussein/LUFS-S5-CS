package exercise_1_builder_pattern;

public class Meal {
	private String item; // The main meal item, beef burger, chicken burger, cheese burger.
	private String drink; // coke or juice
	private String desert; // cake or ice cream
	
	public void setItem(String item) {
		this.item = item;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public void setDesert(String desert) {
		this.desert = desert;
	}
	
	public String toString() {
		return "The Meal serves Mainly: " + item + " with drink: " + drink + " and desert: " + desert;
	}
}
