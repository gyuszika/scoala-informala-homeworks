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

		person.add(new Person("Manager", "CEO", 20, "John Smith"));
		person.add(new Person("Manager", "CFO", 3, "Herr Carlos"));
		person.add(new Person("Manager", "PM", 10, "Vishnu Kumar"));
		person.add(new Person("Engineer", "Dev", 6, "Raj Mahatma"));
		person.add(new Person("Engineer", "Dev", 9, "Sanjiy Marakesh"));
		person.add(new Person("Engineer", "Dev", 1, "Nelson Mondialu"));
	}

	@Test
	public void showEmployeeList() throws WrongSeniorityException {
		System.out.println();
		System.out.println("Employee list:");
		for (Person person : person) {
			System.out.println(person);
			
		}
	}

	@Test
	public void showEmployeeWithoutParking() throws WrongSeniorityException {
		System.out.println();
		System.out.println("Employees without parking space:");
		for (Person person : person) {
			person.showSeniority();
			
		}
	}

	@Test
	public void sortedManagerList() throws WrongSeniorityException {
		System.out.println();
		System.out.println("Manager list:");
		for (Person person : person) {
			person.showManagerList();
			
		}
	}

	@Test
	public void sortedEngineerList() throws WrongSeniorityException {
		System.out.println();
		System.out.println("Engineer list:");
		for (Person person : person) {
			person.showEngineerList();
			
		}
	}
}
