package cloning;

class UnderStandCloning2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Car car = new Car();
		car.setCode(2);
		car.setModel("Tata");
		
		Car clonedCar = car.createClone();
		System.out.println(clonedCar);
		

	}

}


class Vehicle implements Cloneable{
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Vehicle [code=" + code + "]";
	}

	public Vehicle createClone() throws CloneNotSupportedException{
		return (Vehicle)super.clone();
	}
	
}

class Car extends Vehicle implements Cloneable{
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public Car createClone() throws CloneNotSupportedException{
		return (Car)super.createClone();
	}
	@Override
	public String toString() {
		return "Car [model=" + model + "]";
	}
}
