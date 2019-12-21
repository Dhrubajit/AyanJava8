package immutable;

public class MyImmutableImplementationOfPerson {
	private final int id;
	private final int age;
	private final String name;
	private final City city;
	private MyImmutableImplementationOfPerson(int id, int age, String name, City city) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.city = new City(city);
	}
	

	public int getId() {
		return this.id;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return name;
	}

	public City getCity() {
		return new City(this.city);
	}
	
	public static MyImmutableImplementationOfPerson getInstance(int id, int age, String name, City city){
		return new MyImmutableImplementationOfPerson(id,age,name,city);
	}
	
	@Override
	public String toString() {
		return "MyImmutableImplementationOfPerson [id=" + id + ", age=" + age + ", name=" + name + ", city=" + city
				+ "]";
	}

}

class City{
	String name;
	
	public City(String name) {
		super();
		this.name = name;
	}
	
	public City(City city){
		this.name = city.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [name=" + name + "]";
	}
}