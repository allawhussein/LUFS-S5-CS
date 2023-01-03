package exercise_2_factory_method;

public class BeirutPizzaStore extends PizzaStore{
	@Override
	Pizza getCheesePizza() {
		// TODO Auto-generated method stub
		return new BeirutCheesePizza();
	}

	@Override
	Pizza getPepperoniPizza() {
		// TODO Auto-generated method stub
		return new BeirutPepperoniPizza();
	}

	@Override
	Pizza getGreekPizza() {
		// TODO Auto-generated method stub
		return new BeirutGreekPizza();
	}
}
