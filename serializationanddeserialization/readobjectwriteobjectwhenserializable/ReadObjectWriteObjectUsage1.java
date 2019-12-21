package serializationanddeserialization.readobjectwriteobjectwhenserializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ReadObjectWriteObjectUsage1 {

	public static void main(String[] args) {
		try(FileOutputStream file = new FileOutputStream("abc");
				ObjectOutputStream out = new ObjectOutputStream(file);) {
				
				Person serializedPerson = new Person(1000,"Ayan","Kolkata");
				
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
			catch (IOException|ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

	}

}

class Person implements Serializable{
	private int income;
	private String name;
	private String city;
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
	public Person(int income, String name, String city) {
		super();
		this.income = income;
		this.name = name;
		this.city = city;
	}
	
	private void readObject(ObjectInputStream in) throws IOException{
		name = in.readUTF();
		income = in.readInt();
		
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeUTF(name);
		out.writeInt(income);
		
	}
	
}
