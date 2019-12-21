package serializationanddeserialization.staticandserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StaticFieldAndSerializationAndDeserialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//static field can not be serialized
		try(FileOutputStream file = new FileOutputStream("abc");
				ObjectOutputStream out = new ObjectOutputStream(file);) {
				
				Person serializedPerson = new Person("Ayan", 2000, new City("Kolkata"), new Country("India"));
				
				out.writeObject(serializedPerson);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try(FileInputStream file = new FileInputStream("abc");
				ObjectInputStream in = new ObjectInputStream(file)){
				
				Person deserializedPerson = (Person)in.readObject();
				System.out.println(deserializedPerson);
				
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	

}

class Person implements Serializable{
	private int income;
	private String name;
	City city;
	Country country;
	
	public Person(String name, int income, City city, Country country) {
		this.name = name;
        this.income = income;
        this.city = city;
        this.country = country;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	@Override
    public String toString() {
        return "Person [name=" + name + ", income=" + income + ", city=" + city + ", country=" + country + "]";
    }
	
}
class City implements Serializable{
	private static String name;

	public City(String name) {
		this.name = name;
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

class Country implements Serializable {
    private String name;
    public Country(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Country [name=" + name + "]";
    }
    
}