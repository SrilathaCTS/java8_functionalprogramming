package com.functionalprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	
	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		students.add( new Student("sri"));
		students.add( new Student("Abhi"));
		students.add( new Student("Adhe"));
		
		
		// old way of doing
		List<String> names =new ArrayList<>();
		for(Student student : students){
			if(student.getName().startsWith("A")){ //checks  case sensitive
				names.add(student.getName());
			}
		}
		System.out.println(names);
		
		//filter(string -> !string.isEmpty()).forEach(LocalDateTime.now(string));
		
		List<String> names1 = students.stream().map(Student::getName)//.filter(name->name.startsWith("A"))
				.collect(Collectors.toList());
		
		List<Student> names2 = students.stream()//.map(Student::getName)//.filter(name->name.startsWith("A"))
				.collect(Collectors.toList());
		
		System.out.println(names1);
		System.out.println(names2);
		
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered);
		
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		List<String> student = Arrays.asList("Sri", "Anusha", "Sree", "mayuri");
		Stream<Student> studentList = student.stream().map(Student::new).limit(2);
		/*long noofstudents= studentList.count();
		System.out.println(noofstudents);*/
		studentList.forEach(std -> System.out.println(std.getName()));
	}
}

class Student{
	String name;

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}