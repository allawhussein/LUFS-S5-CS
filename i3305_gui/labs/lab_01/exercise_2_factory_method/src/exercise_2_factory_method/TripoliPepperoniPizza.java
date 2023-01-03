package exercise_2_factory_method;

public class TripoliPepperoniPizza implements Pizza{
	public void prepare() {
		System.out.println("Preparing Tripoli Pepporoni Pizza");
	}
	public void bake() {
		System.out.println("Baking Tripoli Pepporoni Pizza");
	}
	public void cut() {
		System.out.println("Cutting Tripoli Pepporoni Pizza");
	}
	public void box() {
		System.out.println("Boxing Tripoli Pepporoni Pizza");
	}
}