package companyemployees;

import java.util.Collection;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		Collection<Person> treeSetPersons = new TreeSet<>();

		treeSetPersons.add(new Person("CEO", 45, "Robert"));
		treeSetPersons.add(new Person("CFO", 25, "Raj"));
		treeSetPersons.add(new Person("HR", 10, "Vishnu"));
		treeSetPersons.add(new Person("PR", 9, "Carlito"));

		for (Person person : treeSetPersons) {
			System.out.println(person);
		}

	}

}
