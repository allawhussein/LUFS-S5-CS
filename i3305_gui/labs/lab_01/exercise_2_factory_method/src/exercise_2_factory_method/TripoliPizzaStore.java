package exercise_2_factory_method;

public class TripoliPizzaStore extends PizzaStore{
	@Override
	Pizza getCheesePizza() {
		// TODO Auto-generated method stub
		return new TripoliCheesePizza();
	}

	@Override
	Pizza getPepperoniPizza() {
		// TODO Auto-generated method stub
		return new TripoliPepperoniPizza();
	}

	@Override
	Pizza getGreekPizza() {
		// TODO Auto-generated method stub
		return new TripoliGreekPizza();
	}
}
