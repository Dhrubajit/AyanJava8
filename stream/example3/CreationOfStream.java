package stream.example3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class CreationOfStream {
	public static void main(String[] args) throws IOException {
		
		/*1.Empty Stream*/
		
		//create empty stream of any reference
		Stream<Integer> emptyStreamOfInteger = Stream.empty();
		Stream<String> emptyStreamOfString = Stream.empty();
		Stream<Person> emptyStreamOfPerson = Stream.empty();
		
		//create empty stream of any primitive
		IntStream emptyStreamOfInt = IntStream.empty();
		LongStream emptyStreamOfLong = LongStream.empty();
		DoubleStream emptyStreamOfDouble = DoubleStream.empty();
		
		
		/*2.Stream of Collection*/
		Collection<String> collection = Arrays.asList("a","b","c");
		Stream<String> streamOfCollection = collection.stream();
		
		
		/*3.Stream of Array*/
		Stream<String> streamOfArray = Stream.of("a","b","c");
		String[] arrayOfString = {"a","b","c"};
		//lower range exclusive,upper range inclusive
		//above two version of method is also provided for int,long and double
		//inside Arrays class which will generate IntStream,LongStream and DoubleSTream explicitly
		Stream<String> streamOfArrayFull = Arrays.stream(arrayOfString);
		Stream<String> streamOfArrayPart = Arrays.stream(arrayOfString,1,3);
		
		
		/*4.Using Stream.builder() which is a mutable builder */
		/*  When builder is used the desired type should be additionally specified in the right
		 *  part of the statement, otherwise the build() method will create an instance of the
		 *  Stream<Object>
		 */
		Stream<String> streamBuilder =Stream.<String>builder().add("a").add("b").add("c").build();
		
		/*Stream of String*/
		/*String can also be used as a source for creating a stream.
		 * With the help of the chars() method of the String class. 
		 * Since there is no interface CharStream in JDK, the IntStream
		 *  is used to represent a stream of chars instead*/

		IntStream streamOfChars = "abc".chars();
		//The following example breaks a String into sub-strings according to specified RegEx
		Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");
		
		/*Stream of File*/
		/*Java NIO class Files allows to generate a Stream<String> of a text file through
		 * the lines() method. Every line of the text becomes an element of the stream:*/
		Path path = Paths.get("C:\\file.txt");
		Stream<String> streamOfStrings = Files.lines(path);
		Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
		
		//Stream.iterate
		Stream.iterate(0, n -> n+1).limit(10).forEach(System.out::println);
		//iterate fibonacci series using Stream Iterate
		Stream.iterate(new int[]{0,1}, n -> new int[]{n[1],n[0]+n[1]}).limit(10).map(n -> n[0]).forEach(System.out::println);
		
		//sum of all fibonacci values
		int sum = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(n -> n[0]) // Stream<Integer>
                .mapToInt(n -> n)
                .sum();
		
		//Stream.generate 
		Stream<String> stream = Stream.generate(() -> Double.toString(Math.random() * 1000)).limit(10);
		
		
		
		
	}
}


class Person{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}