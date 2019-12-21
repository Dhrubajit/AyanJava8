package exception;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class TryWithResourcesTest {
	public static void main(String[] args) throws SQLException, IOException {
		
		/*try{
			method();
		}
		catch(Throwable e){
			System.out.println(" Supp  "+ e);
		}*/
		try{
			method2();
		}
		catch(SQLException e){
			System.out.println(e.getCause());
		}
	}

	public static void method() throws SQLException, IOException{
		/*try(SomeResource resource = new SomeResource()){
			System.out.println("try with resources");
			throw new SQLException();
		} */
		SomeResource resource= null;
		try{
			resource = new SomeResource();
			System.out.println("try with finally");
			throw new SQLException();
		}
		finally{
			resource.close();
		}
		
		
	}
	
	static boolean flag = false;
	public static void method1() throws SQLException,IOException{
		/*try(SomeResource resource = new SomeResource()){
			System.out.println("try with resources");
			throw new SQLException();
		} */
		SomeResource resource= null;
		try{
			resource = new SomeResource();
			System.out.println("try with finally");
			if(flag)
				throw new SQLException();
			else 
				throw new IOException();
		}
		catch(Exception e){
			System.out.println("Jahhhh!!!");
			throw e;
		}
		
	}
	
	public static void method2() throws SQLException, IOException{
		SomeResource resource= null;
		try{
			throw new SQLException();
		}
		catch(SQLException e){
			throw new IOException(e);
		}
		
	}
}
