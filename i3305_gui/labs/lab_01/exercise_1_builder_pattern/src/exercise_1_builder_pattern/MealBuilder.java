package exercise_1_builder_pattern;

abstract class MealBuilder {
	Meal meal;
	
	public void createNewMeal() {
		meal = new Meal();
	}
	public Meal getMeal() {
		return meal;
	}
	public abstract void BuilItem(String item);
	public abstract void BuilDrink();
	public abstract void BuilDesert();
}
