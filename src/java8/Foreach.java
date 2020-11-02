package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Foreach {

	public static void main(String[] args) {

		List<String> words = new ArrayList<>();
		words.add("alura online");
		words.add("casa do código");
		words.add("caelum");
		
		//lambda with compare method
//		words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
	
		//or lambda without compare method
		words.sort((s1, s2) -> s1.length() - s2.length()); 

//		words.sort((s1, s2) -> {
//			if(s1.length() < s2.length())
//				return -1;
//			if(s1.length() > s2.length())
//				return 1;
//			return 0;
//		});
//		
//		words.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String s1, String s2) {
//				if(s1.length() < s2.length())
//					return -1;
//				if(s1.length() > s2.length())
//					return 1;
//				return 0;
//			}
//		});
		
		//using comparator function
//		Comparator<String> comparator = new ComparatorOfStringBySize();
//		Collections.sort(words, comparator);

		//using foreach with lambda
//		words.forEach(s -> System.out.println(s));
		
		//using method reference
		words.forEach(System.out::println);
		
		//using foreach
//		words.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//		});
	}

}

class ComparatorOfStringBySize implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}