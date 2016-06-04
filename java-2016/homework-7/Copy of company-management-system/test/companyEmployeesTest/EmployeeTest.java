package companyEmployeesTest;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import companyemployees.Employee;
import companyemployees.WrongSeniorityException;

public class EmployeeTest {

	private Set<Employee> employee;

	@Before
	public void initCollections() {

		this.employee = new TreeSet<>();

		employee.add(new Employee("Manager", "CEO", 20, "John Smith"));
		employee.add(new Employee("Manager", "CFO", 3, "Herr Carlos"));
		employee.add(new Employee("Manager", "PM", 10, "Vishnu Kumar"));
		employee.add(new Employee("Engineer", "Dev", 0, "Raj Mahatma"));
		employee.add(new Employee("Engineer", "Dev", 9, "Sanjiy Marakesh"));
		employee.add(new Employee("Engineer", "Dev", 1, "Nelson Mondialu"));
	}

	@Test
	public void showEmployeeList() {
		System.out.println();
		System.out.println("Employee list:");
		for (Employee employee : employee) {
			System.out.println(employee);

		}
	}

	@Test
	public void seniorityCheckInMonths() throws WrongSeniorityException {
		System.out.println();
		System.out.println("Seniority in months:");
		for (Employee employee : employee) {
			employee.seniorityException();
		}
	}

	@Test
	public void showEmployeeWithoutParking() {
		System.out.println();
		System.out.println("Employees without parking space:");
		for (Employee employee : employee) {
			employee.showSeniority();

		}
	}

	@Test
	public void sortedManagerList() {
		System.out.println();
		System.out.println("Manager list:");
		for (Employee employee : employee) {
			employee.showManagerList();

		}
	}

	@Test
	public void sortedEngineerList() {
		System.out.println();
		System.out.println("Engineer list:");
		for (Employee employee : employee) {
			employee.showEngineerList();

		}
	}
}
