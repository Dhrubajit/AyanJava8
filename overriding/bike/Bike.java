package overriding.bike;

import overriding.vehicle.Vehicle;

public class Bike extends Vehicle{
	private static final int NO_OF_TYRES=2;

	@Override
	protected int getNoOfTyres() {
		// TODO Auto-generated method stub
		return NO_OF_TYRES;
	}

}
