package exercise_2_factory_method;

public class TripoliCheesePizza extends CheesePizza{
	public void prepare() {
		System.out.println("Preparing Tripoli Cheese Pizza");
	}
	public void bake() {
		System.out.println("Baking Tripoli Cheese Pizza");
	}
	public void cut() {
		System.out.println("Cutting Tripoli Cheese Pizza");
	}
	public void box() {
		System.out.println("Boxing Tripoli Cheese Pizza");
	}
}
