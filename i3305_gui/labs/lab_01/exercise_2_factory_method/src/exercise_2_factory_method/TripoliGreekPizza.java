package exercise_2_factory_method;

public class TripoliGreekPizza extends GreekPizza {
	public void prepare() {
		System.out.println("Preparing Tripoli Greek Pizza");
	}
	public void bake() {
		System.out.println("Baking Tripoli Greek Pizza");
	}
	public void cut() {
		System.out.println("Cutting Tripoli Greek Pizza");
	}
	public void box() {
		System.out.println("Boxing Tripoli Greek Pizza");
	}
}
