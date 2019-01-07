package com.functionalprograming;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Terminal operations return a result of a certain type instead of again a Stream.
 *
 */
public class StreamTerminalOperators {

	public static void main(String[] args) {
		
		
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		
	//forEach
		Stream.of("A:B:C".split(":")).forEach(pr -> System.out.println(pr)); 
		//A
		//B
		//C
		
	//match
		//matching operations can be used to check whether a certain predicate matches the stream
		boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult); //true

		matchedResult = memberNames.stream()
                .allMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult); //false

		matchedResult = memberNames.stream()
                .noneMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult); //false

	//count	(It returning the number of elements in the stream as a long.)
		long totalMatched = memberNames.stream()
                .filter((s) -> s.startsWith("S"))
                .count();
		System.out.println(totalMatched); //2

	//Optional (a reduction on the elements of the stream with the given function. The result is an Optional holding the reduced value.)	
		Optional<String> reduced = memberNames.stream()
                .reduce((s1,s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println); //Amitabh#Shekhar#Rahul#Shahrukh#Yana#Lokesh
		
		
	}
	
}
