package exercise_2_factory_method;

public abstract class PizzaStore {
	
	public Pizza OrderPizza(String pizzaType) {
		
		Pizza pizza = null;
		if (pizzaType.equals("Cheese")) {
			pizza = getCheesePizza();
		}
		else if (pizzaType.equals("Pepporoni")) {
			pizza = getPepperoniPizza();
		}
		else if (pizzaType.equals("Greek")) {
			pizza = getGreekPizza();
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	abstract Pizza getCheesePizza();
	abstract Pizza getPepperoniPizza();
	abstract Pizza getGreekPizza();
}
