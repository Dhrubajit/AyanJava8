package stream.example4;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CollectorUsecase {

	public static void main(String[] args) {
		List<Employee> employeeList = Arrays.asList(new Employee("Ayan",317,2000),new Employee("Abhishek",319,3000));
		
		//partitioningBy - PartitioningBy is a specialized case of groupingBy that accepts a Predicate instance and
		//collects Stream elements into a Map instance that stores Boolean values as keys and collections as values.
		//Under the “true” key, you can find a collection of elements matching the given Predicate, and under the
		//“false” key, you can find a collection of elements not matching the given Predicate.
		Map<Boolean,List<Employee>> empMap = employeeList.stream().collect(partitioningBy(e -> e.getId()>318));
		
		//joining
		System.out.println(employeeList.stream().map(e -> e.getName()).collect(joining()));
		System.out.println(employeeList.stream().map(e -> e.getName()).collect(joining(", ")));
		System.out.println(employeeList.stream().map(e -> e.getName()).collect(joining(", ","{{","}}")));
		
		//summingInt/Long/Double
		Integer empSalarySum = employeeList.stream().collect(summingInt(e -> e.getSalary()));
		System.out.println(empSalarySum);
		
		//summarizingInt/Long/Double
		IntSummaryStatistics empSalarySumStat = employeeList.stream().collect(summarizingInt(e -> e.getSalary()));
		System.out.println(empSalarySumStat);
		
		//count number of elements in stream
		Long count = employeeList.stream().collect(counting());
		System.out.println(count);
		
		//maxBy/minBy
		Optional<Employee> maxSalariedEmp = employeeList.stream().collect(maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println(maxSalariedEmp.get().getName());
		
		
	}

}


class Employee{
	private String name;
	private int id;
	private int salary;
	
	public Employee(String name, int id,int salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}