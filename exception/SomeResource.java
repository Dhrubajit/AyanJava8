package exception;

import java.io.IOException;

public class SomeResource implements AutoCloseable {

	@Override
	public void close(){
		System.out.println("closing ");
		int i = 3/0;

	}

}
