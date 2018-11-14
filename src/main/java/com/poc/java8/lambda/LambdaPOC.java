package com.poc.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaPOC {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<Person>();
		people.add(new Person("jay", 27));
		people.add(new Person("RAM", 55));
		people.add(new Person("malli", 19));
		people.add(new Person("NAG", 78));
		people.add(new Person("vin", 19));
		Comparator<Person> comp = (p1, p2) -> p1.getName().compareTo(p2.getName());
		Collections.sort(people,comp);
		people.forEach(P -> {
				System.out.println(P.getName());
	});
	}
}
