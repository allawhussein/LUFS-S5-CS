package exercise_2_factory_method;

public class Store {
	public static void main(String[] args) {
		PizzaStore p = new TripoliPizzaStore();
		Pizza pizza = p.OrderPizza("Greek");
		
	}
}
