package com.functionalprograming;

public  class InterfaceExamlpes implements Interface12, Interface23 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	/*if the method in implemented both interfaces then we have to override that in implementation also */
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface12.print("abc");
	}
}
interface Interface12 {

	void method1(String str);
	
	static void print(String string) {
	}

	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
}

interface Interface23 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}