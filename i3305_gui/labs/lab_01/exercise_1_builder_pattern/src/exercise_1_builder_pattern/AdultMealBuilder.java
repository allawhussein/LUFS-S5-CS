package exercise_1_builder_pattern;

public class AdultMealBuilder extends MealBuilder {
	public void BuilerItem(String item) {
		meal.setItem(item);
	}
	public void BuilerDrink() {
		meal.setDrink("Coke");
	}
	public void BuilerDesert() {
		meal.setDesert("Ice Cream");
	}
	public Meal getMeal(String mainItem) {
		BuilerItem(mainItem);
		BuilerDrink();
		BuilerDesert();
		return meal;
	}
}
