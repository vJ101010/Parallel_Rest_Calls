package com.poc.java8.lambda;

public class TestJava8 {

	public static void main(String[] args) {
		
		TestInterface testInterface = () -> System.out.println("Java 8 is working");
		testInterface.test();
		
		LamdaArgsMethod argsMethod = (v1,v2) -> {
			
			int result = v1*v2;
			System.out.println("The result is ::"+result);
		};
		
		argsMethod.add(123, 456);
	}
}
