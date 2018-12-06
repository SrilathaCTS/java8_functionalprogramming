package com.functionalprograming;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
 
/* parallel streams*/
public class ParallelStreamExample {
	
	public static void main(String[] args) throws IOException {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(sumStream(list));
		
		list.remove(new Integer(2));
		
		System.out.println(list);
		

		List<Integer> myList1 = new ArrayList<>();
		for(int i=0; i<100; i++) myList1.add(i);
				
		//sequential stream
		Stream<Integer> sequentialStream = myList1.stream();
				System.out.println(sequentialStream);
		//parallel stream
		Stream<Integer> parallelStream = myList1.parallelStream();
		System.out.println(parallelStream);
		
		
				//creating sample Collection
				List<Integer> myList = new ArrayList();
				for(int i=0; i<10; i++) myList.add(i);
				
				//traversing using Iterator
				Iterator<Integer> it = myList.iterator();
				while(it.hasNext()){
					Integer i = it.next();
					System.out.println("Iterator Value::"+i);
				}
				
				//traversing through forEach method of Iterable with anonymous class
				myList.forEach(new Consumer<Integer>() {

					public void accept(Integer t) {
						System.out.println("forEach anonymous class Value::"+t);
					}

				});
				
				//traversing with Consumer interface implementation
				MyConsumer action = new MyConsumer();
				myList.forEach(action);
				
	 /* default and static*/
	 
				 Interface1.print("adas");
				 MyClass cls = new MyClass();
				 cls.log("sri");
	
				 /*old way */ 
				 /*Runnable r = new Runnable(){
						@Override
						public void run() {
							System.out.println("old Runnable");
						}};*/
						Runnable r1= () -> {
							System.out.println("My Runnable");
						};
						Interface1 i1 = (s) -> System.out.println(s);
						
						i1.log("abc");
						 throw new IOException();
			}
	private static int sumStream(List<Integer> list) {
		int sum=  list.stream().filter(i -> i < 10).mapToInt(i -> i).sum();
		return sum;
	}
}
class forEachExample{
	
}
//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}


}
/*2 --- interface with default and static method*/
interface Interface1 {

	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
	//trying to override Object method gives compile time error as
	//"A default method cannot override a method from java.lang.Object"
	
//	default String toString(){
//		return "i1";
//	}
	
}
interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}

class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
		System.out.println("method1");
	}

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.print("abc");
	}
	
}