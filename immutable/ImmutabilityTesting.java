package immutable;

public class ImmutabilityTesting {

	public static void main(String[] args) {
		String kolkataString = "Kolkata";
		City kolkata = new City(kolkataString);
		String name = "ayan";
		MyImmutableImplementationOfPerson immutablePerson = MyImmutableImplementationOfPerson.getInstance(1,28,name,kolkata);
		System.out.println(immutablePerson);
		name = "Sayan";
		System.out.println(immutablePerson);
		kolkata = new City("Mumbai");
		System.out.println(immutablePerson);
		City unknown = immutablePerson.getCity();
		unknown.setName("Mumbai");
		System.out.println(immutablePerson);
		
		// The above happened due to the fact that even if
		// String is a reference variable, it does not require cloning 
		// in order to support immutability
		
	}

}
