package com.fis.lambdaApproaches;

import java.util.List;

public class lambdaDemo {
	interface CheckPerson{
		boolean test(Person p);
	}
	//Approach 1: Create Methods That Search for Members That Match One Characteristic
	//One simplistic approach is to create several methods; each method searches for members that match one characteristic, such as gender or age. The following method prints members that are older than a specified age:

	public static void printPersonsOlderThan(List<Person> roster, int age) {
	    for (Person p : roster) {
	        if (p.getAge() >= age) {
	            p.printPerson();
	        }
	    }
	}
	//Approach 2: Create More Generalized Search Methods
	//The following method is more generic than printPersonsOlderThan; it prints members within a specified range of ages:

	public static void printPersonsWithinAgeRange(
	    List<Person> roster, int low, int high) {
	    for (Person p : roster) {
	        if (low <= p.getAge() && p.getAge() < high) {
	            p.printPerson();
	        }
	    }
	}
	public static void main(String[] args) {
		List<Person> roster = Person.createRoster();
		
		for(Person p : roster) {
			p.printPerson();
		}
		System.out.println("Approach 1---------------------------------------");
		printPersonsOlderThan(roster,20);
		System.out.println();
		
		System.out.println("Approach 2----------------------------------------");
		printPersonsWithinAgeRange(roster,14,30);
		System.out.println();
	}

}
