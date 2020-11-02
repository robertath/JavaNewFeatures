package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import static java.util.Comparator.*;

public class DefaultMethods {

	public static void main(String[] args) {

		List<String> words = new ArrayList<>();
		words.add("alura online");
		words.add("casa do código");
		words.add("caelum");
		
		//Using default method comparing of Comparator Interface
//		Function<String, Integer> function = s -> s.length();
//		Comparator<String> comparator = Comparator.comparing(function);
//		words.sort(comparator);
//		
		
		//With lambda - Using default method comparing of Comparator Interface
//		words.sort(Comparator.comparing(s -> s.length()));
		
		//with method reference - Using default method comparing of Comparator Interface
//		words.sort(Comparator.comparing(String::length));
		
		//or with static - import static java.util.Comparator.*;
//		words.sort(comparing(String::length));
		
		//order by alphabetic order
		words.sort(String.CASE_INSENSITIVE_ORDER);
		
		//lambda
//		words.forEach(s -> System.out.println(s));
		
		//foreach with method reference
		words.forEach(System.out::println);
	}

}
