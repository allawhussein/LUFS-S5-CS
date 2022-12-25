package exercise_1_builder_pattern;

public class KidMealBuilder extends MealBuilder {
	public void BuilerItem(String item) {
		meal.setItem(item);
	}
	public void BuilerDrink() {
		meal.setDrink("Juice");
	}
	public void BuilerDesert() {
		meal.setDesert("Cake");
	}
	public Meal getMeal(String mainItem) {
		BuilerItem(mainItem);
		BuilerDrink();
		BuilerDesert();
		return meal;
	}
}
