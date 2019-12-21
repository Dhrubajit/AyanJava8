package serializationanddeserialization.readresolvewritereplace;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class ReadResolveWriteReplaceUnderstanding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gender1 maleObjectToSerializeForImplementationWithoutReadResolve = Gender1.getMale();
		try(FileOutputStream file = new FileOutputStream("abc");
			ObjectOutputStream out = new ObjectOutputStream(file);) {
			out.writeObject(maleObjectToSerializeForImplementationWithoutReadResolve);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gender1 maleObjectToDeserializeForImplementationWithoutReadResolve = null;;
		try(FileInputStream file = new FileInputStream("abc");
			ObjectInputStream in = new ObjectInputStream(file)){
			maleObjectToDeserializeForImplementationWithoutReadResolve = (Gender1)in.readObject();
			System.out.println(maleObjectToDeserializeForImplementationWithoutReadResolve);
		}
		catch (IOException|ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		System.out.println("This two objects are same - " + (maleObjectToSerializeForImplementationWithoutReadResolve == maleObjectToDeserializeForImplementationWithoutReadResolve));
		
		
		
		Gender2 maleObjectToSerializeForImplementationWithReadResolve = Gender2.getMale();
		try(FileOutputStream file = new FileOutputStream("abc");
			ObjectOutputStream out = new ObjectOutputStream(file);) {
			out.writeObject(maleObjectToSerializeForImplementationWithReadResolve);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gender2 maleObjectToDeserializeForImplementationWithReadResolve = null;;
		try(FileInputStream file = new FileInputStream("abc");
			ObjectInputStream in = new ObjectInputStream(file)){
			maleObjectToDeserializeForImplementationWithReadResolve = (Gender2)in.readObject();
			System.out.println(maleObjectToDeserializeForImplementationWithReadResolve);
		}
		catch (IOException|ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		System.out.println("This two objects are same - " + (maleObjectToSerializeForImplementationWithReadResolve == maleObjectToDeserializeForImplementationWithReadResolve));

	}

}


//Implementation without readResolve will create new object in a Single JVM execution
//where it is clearly logical that the system should have two object.
class Gender1 implements Serializable{
	private static final Gender1 MALE = new Gender1("MALE");
	private static final Gender1 FEMALE = new Gender1("FEMALE");
	
	private String name;
	
	private Gender1(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Gender1 getMale() {
		return MALE;
	}

	public static Gender1 getFemale() {
		return FEMALE;
	}

	@Override
	public String toString() {
		return "Gender1 [name=" + name + "]";
	}

	
	
}


class Gender2 implements Serializable{
	private static final Gender2 MALE = new Gender2("MALE");
	private static final Gender2 FEMALE = new Gender2("FEMALE");
	
	private String name;
	
	private Gender2(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Gender2 getMale() {
		return MALE;
	}

	public static Gender2 getFemale() {
		return FEMALE;
	}
	
	private Object readResolve() throws ObjectStreamException{
		if("MALE".equals(name)){
			return MALE;
		}
		else
			return FEMALE;
	}

	@Override
	public String toString() {
		return "Gender2 [name=" + name + "]";
	}

	
}