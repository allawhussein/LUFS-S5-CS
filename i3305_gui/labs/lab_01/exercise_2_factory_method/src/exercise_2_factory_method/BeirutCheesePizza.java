package exercise_2_factory_method;

public class BeirutCheesePizza extends CheesePizza{
	public void prepare() {
		System.out.println("Preparing Beirut Cheese Pizza");
	}
	public void bake() {
		System.out.println("Baking Beirut Cheese Pizza");
	}
	public void cut() {
		System.out.println("Cutting Beirut Cheese Pizza");
	}
	public void box() {
		System.out.println("Boxing Beirut Cheese Pizza");
	}
}
