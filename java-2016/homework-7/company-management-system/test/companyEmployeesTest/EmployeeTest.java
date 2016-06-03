package companyEmployeesTest;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import companyemployees.Person;
import companyemployees.WrongSeniorityException;

public class EmployeeTest {

	private Set<Person> person;

	@Before
	public void initCollections() {

		this.person = new TreeSet<>();

		person.add(new Person("CEO", 20, "John Smith"));
		person.add(new Person("CFO", 3, "Herr Carlos"));
		person.add(new Person("PM", 10, "Vishnu Kumar"));
		person.add(new Person("Dev", 6, "Raj Mahatma"));
		person.add(new Person("Dev", 9, "Sanjiy Marakesh"));
	}

	@Test
	public void showEmployeeList() throws WrongSeniorityException {
		System.out.println("Employee list:");
		for (Person person : person) {
			System.out.println(person);
			System.out.println();
		}
	}

	@Test
	public void showEmployeeWithoutParking() throws WrongSeniorityException {
		System.out.println();
		System.out.println("Employees without parking space:");
		for (Person person : person) {
			person.showSeniority();
			System.out.println();
		}
	}
}
