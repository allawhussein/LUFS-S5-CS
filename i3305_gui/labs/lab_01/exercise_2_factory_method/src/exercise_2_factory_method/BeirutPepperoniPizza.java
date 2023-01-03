package exercise_2_factory_method;

public class BeirutPepperoniPizza extends PepperoniPizza {
	public void prepare() {
		System.out.println("Preparing Beirut Pepporoni Pizza");
	}
	public void bake() {
		System.out.println("Baking Beirut Pepporoni Pizza");
	}
	public void cut() {
		System.out.println("Cutting Beirut Pepporoni Pizza");
	}
	public void box() {
		System.out.println("Boxing Beirut Pepporoni Pizza");
	}
}