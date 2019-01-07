package com.functionalprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Intermediate operations return the stream itself so you can chain multiple method calls in a row
 *
 */
public class StreamsIntermediateOperations {

	public static void main(String[] args) {
		//Java Stream Intermediate Operations
	//filter
		/*filter (use filter() method to test stream elements for a condition and generate filtered list.)*/
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);

		Stream<Integer> highNums = myList.stream().filter(getNumbers()); //filter numbers greater than 90
		System.out.print("High Nums greater than 90=");
		highNums.forEach(p -> System.out.print(p+" "));//"High Nums greater than 90=91 92 93 94 95 96 97 98 99 "
		
	//map
		/*use map() to apply functions to an stream. below example to apply upper case function to a list of Strings */
		Stream<String> names = Stream.of("srI", "latha", "venu","sathvik");
		System.out.println(names.map(s -> {
				return s.toUpperCase();
			}).collect(Collectors.toList())); //[SRI, LATHA, VENU, SATHVIK]
  
	//sorted
		Stream<String> names2 = Stream.of("sri", "latha", "venu","sathvik","12344");
		List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted); // [venu, sri, sathvik, latha, 12344]

		Stream<String> names3 = Stream.of("sri", "latha", "venu","sathvik","12344");
		// if we use name2.sorted then will get error as Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
		List<String> naturalSorted = names3.sorted().collect(Collectors.toList()); 
		System.out.println(naturalSorted); //[12344, latha, sathvik, sri, venu]

  //flatMap
		
		Stream<List<String>> namesOriginalList = Stream.of(
				Arrays.asList("Pankaj"), 
				Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));
			//flat the stream from List<String> to String stream
			Stream<String> flatStream = namesOriginalList
				.flatMap(strList -> strList.stream());

			flatStream.forEach(System.out::print);//PankajDavidLisaAmitAmitabh
			
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		
		memberNames.stream().filter((s) -> s.startsWith("A"))
		.forEach(System.out::println);
		
		memberNames.stream().filter((s) -> s.startsWith("A"))
        .map(String::toUpperCase)
        .forEach(System.out::println);
		
		memberNames.stream().sorted()
        .map(String::toUpperCase)
        .forEach(System.out::println);
	}
	// predicate method
	private static Predicate<Integer> getNumbers( ){
		return number -> number > 90;
	}
}
