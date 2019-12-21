package overriding.car;

import overriding.vehicle.Vehicle;

public class Car extends Vehicle{
	private static final int NO_OF_TYRES=4;

	@Override
	protected int getNoOfTyres() {
		return NO_OF_TYRES;
	}
	
}
