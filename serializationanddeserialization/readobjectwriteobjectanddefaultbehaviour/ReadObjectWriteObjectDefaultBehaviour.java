package serializationanddeserialization.readobjectwriteobjectanddefaultbehaviour;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//if default behavior is chosen even after using readObject and writeObject method
//then both method must use default behavior As, we don't know the order in which default serialization
//serialize the object. So, we will not know how to deserialize sequentially. Also, if we use this methods
//it will serialize/deserialize all non-static,non-transient object state data

public class ReadObjectWriteObjectDefaultBehaviour {

	public static void main(String[] args) {
		try(FileOutputStream file = new FileOutputStream("abc");
			ObjectOutputStream out = new ObjectOutputStream(file);) {
			Person serializedPerson = new Person(1000,"Ayan","Kolkata");
			out.writeObject(serializedPerson);

		} catch (IOException e) {
			e.printStackTrace();
		}
		try(FileInputStream file = new FileInputStream("abc");
			ObjectInputStream in = new ObjectInputStream(file)){
			Person deserializedPerson = (Person)in.readObject();
			System.out.println(deserializedPerson);

		}
		catch (IOException|ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

}



class Person implements Serializable{
	private int income;
	private String name;
	private String city;
	
	public Person(int income, String name, String city) {
		super();
		this.income = income;
		this.name = name;
		this.city = city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Person [income=" + income + ", name=" + name + ", city=" + city + "]";
	}
	

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		System.out.println("defaultReadObject should be the only operation if at all default behaviour is needed."
				+ "No other operation can be performed on ObjectInputStream before"
				+ " or after that otherwise it will throw runtime error. If we read ObjectInputStream before"
				+ " defaultReadObject, we will get StreamCorruptedException and if we read "
				+ " after defaultReadObject we will get EOFException");
		in.defaultReadObject();
		

	}

	private void writeObject(ObjectOutputStream out) throws IOException{
		System.out.println("defaultWriteObject should be the only operation if at all default behaviour is needed."
				+ "No write operation can be performed on ObjectOutputStream before"
				+ "that otherwise it will throw StreamCorruptedException.If we write on ObjectOutputStream"
				+ " after defaultWriteObject, then it will not effect anything.");
		
		out.defaultWriteObject();

	}

}