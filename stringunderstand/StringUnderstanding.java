package stringunderstand;

import java.lang.reflect.Field;

public class StringUnderstanding {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(showInternalCharArrayHashCode(s1));
		System.out.println(showInternalCharArrayHashCode(s2));
		
		String s3 = "abc";
		String s4 = new String("abc");
		System.out.println(showInternalCharArrayHashCode(s3));
		System.out.println(showInternalCharArrayHashCode(s4));
		
		String s5 = "abc";
		String s6 = "?abc".substring(1);
		System.out.println(showInternalCharArrayHashCode(s5));
		System.out.println(showInternalCharArrayHashCode(s6));

	}
	
	private static int showInternalCharArrayHashCode(String s) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	    final Field value = String.class.getDeclaredField("value");
	    value.setAccessible(true);
	    return value.get(s).hashCode();
	}

}
