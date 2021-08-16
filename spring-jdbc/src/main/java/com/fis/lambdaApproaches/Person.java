package com.fis.lambdaApproaches;

import java.time.LocalDate;

//import java.time.LocalDate;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	Person(String nameArg, LocalDate birthdayArgs, Sex genderArgs, String emailArgs) {
		name = nameArg;
		birthday = birthdayArgs;
		gender = genderArgs;
		emailAddress = emailArgs;
	}

	public int getAge() {
		return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}

	public void printPerson() {
		System.out.println(name + "," + this.getAge());
	}

	public Sex getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public static List<Person> createRoster() {
		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Ankush", IsoChronology.INSTANCE.date(1980, 6, 22), Person.Sex.MALE, "ankush@gmail"));
		roster.add(new Person("Anu", IsoChronology.INSTANCE.date(1989, 9, 12), Person.Sex.FEMALE, "anu@gmail"));
		roster.add(new Person("Ani", IsoChronology.INSTANCE.date(1999, 8, 22), Person.Sex.MALE, "ani@gmail"));
		roster.add(new Person("Anki", IsoChronology.INSTANCE.date(1980, 6, 22), Person.Sex.FEMALE, "anki@gmail"));
		return roster;
	}
}