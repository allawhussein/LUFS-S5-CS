package exercise_2_factory_method;

public class BeirutGreekPizza extends GreekPizza {
	public void prepare() {
		System.out.println("Preparing Beirut Greek Pizza");
	}
	public void bake() {
		System.out.println("Baking Beirut Greek Pizza");
	}
	public void cut() {
		System.out.println("Cutting Beirut Greek Pizza");
	}
	public void box() {
		System.out.println("Boxing Beirut Greek Pizza");
	}
}
