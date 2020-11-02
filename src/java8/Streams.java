package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.Map;


class Course {

	private String name;
	private int students;

	public Course(String name, int students) {
		this.name = name;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudents() {
		return students;
	}

	public void setStudents(int students) {
		this.students = students;
	}

}

public class Streams {

	public static void main(String[] args) {

		List<Course> courses = new ArrayList<Course>();
		courses.add(new Course("Python", 45));
		courses.add(new Course("JavaScript", 150));
		courses.add(new Course("Java 8", 113));
		courses.add(new Course("C", 55));

		// with lambda
//		courses.sort(Comparator.comparingInt(c -> c.getStudents()));

		// or with method reference
//		courses.sort(Comparator.comparingInt(Course::getStudents));

		//Using Stream to filter 
//		Stream<Course> strOfCourse = courses.stream().filter(c -> c.getStudents() > 100);
//		courses.forEach(c -> System.out.println(c.getName()));

		//Using Stream without a new variable
		System.out.println("Using Stream without a new variable");
		courses.stream()
		.filter(c -> c.getStudents() > 100)
		.forEach(c -> System.out.println(c.getName()));
		
		//If we want to filter in a new flow
//		courses.stream()
//		.filter(c -> c.getStudents() > 100)
//		.map(c -> c.getStudents())
//		.forEach(x -> System.out.println(x));
		
		//With method reference: If we want to filter in a new flow
//		courses.stream()
//		.filter(c -> c.getStudents() > 100)
//		.map(Course::getStudents)
//		.forEach(System.out::println);
		
		//With method reference: If we want to filter in a new flow
		System.out.println("------------------");
		System.out.println("Sum mapToInt() - With method reference: If we want to filter in a new flow");
		int sum = courses.stream()
		.filter(c -> c.getStudents() > 100)
		.mapToInt(Course::getStudents)
		.sum();
		System.out.println("Sum: " + sum);
		
		//With method reference: If we want to filter in a new flow
		System.out.println("------------------");
		System.out.println("Avarage mapToDouble() - With method reference: If we want to filter in a new flow");
		OptionalDouble avg = courses.stream()
		.filter(c -> c.getStudents() > 100)
		.mapToDouble(Course::getStudents)
		.average();
		System.out.println("Avarage: " + avg);
		
		//Using Optional and 
		System.out.println("------------------");
		System.out.println("Using Optional class and get() method to take object");
		Optional<Course> optional = courses.stream()
		.filter(c -> c.getStudents() > 100)
		.findAny();
		
		//using methot get() to take result
		Course course = optional.get();
		System.out.println("Name: " + course.getName() + " / Amount Students: " + course.getStudents());
		
		//using method orElse
		System.out.println("------------------");
		System.out.println("using method orElse");
		Course course2 = optional.orElse(null);
		System.out.println("Name: " + course.getName() + " / Amount Students: " + course.getStudents());
		
		//or without temporary variable
		System.out.println("------------------");
		System.out.println("or whitout a temporary variable");
		courses.stream()
			.filter(c -> c.getStudents() > 100)
			.findAny()
			.ifPresent(c -> System.out.println("Name: " + c.getName() + " / Amount Students: " + c.getStudents()));
		
		
		System.out.println("------------------");
		System.out.println("Stream to collection List");
		List<Course> results = courses.stream()
				.filter(c -> c.getStudents() > 100)
				.collect(Collectors.toList());
		results.forEach(c -> System.out.println("Name: " + c.getName() + " / Amount Students: " + c.getStudents()));
		
		System.out.println("------------------");
		System.out.println("Stream to collection Map");
		Map map = courses.stream()
				.filter(c -> c.getStudents() > 100)
				.collect(Collectors.toMap(c -> c.getName(), c -> c.getStudents()));
		
		
	}

}
