package overriding.vehicle;

public abstract class Vehicle {

	protected abstract int getNoOfTyres();
	
	public void doSomethingWithTyresWhichIsCommon(){
		System.out.println("I have written some logic in this parent class for all kinds of vehicle. As this logic is generic"
				+ " for all kinds of vehicle this method is written in this subclass."
				+ " But, noOfTyres is a subclass attribute by nature" + getNoOfTyres());
	}
}
