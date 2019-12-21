package overriding;

import overriding.bike.Bike;
import overriding.car.Car;
import overriding.vehicle.Vehicle;

public class TestOverridingUseCase {
	
	public static void main(String[] args) {
		
		doSomethingSoThatPolymorphismCanBeUtilized(new Car());
		doSomethingSoThatPolymorphismCanBeUtilized(new Bike());
		
	}

	private static void doSomethingSoThatPolymorphismCanBeUtilized(Vehicle vehicle) {
		vehicle.doSomethingWithTyresWhichIsCommon();
		
	}

}
