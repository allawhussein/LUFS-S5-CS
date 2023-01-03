package exercise_2_factory_method;

public abstract class PepperoniPizza implements Pizza {
	public void prepare() {
		System.out.println("Preparing Pepporoni Pizza");
	}
	public void bake() {
		System.out.println("Baking Pepporoni Pizza");
	}
	public void cut() {
		System.out.println("Cutting Pepporoni Pizza");
	}
	public void box() {
		System.out.println("Boxing Pepporoni Pizza");
	}
}
