package companyemployees;

import java.util.ArrayList;
import java.util.List;

/**
 * This Employee class is a child class of Employee, allowing to create the
 * person list containing Name, company position and active years.
 * 
 * @author Gyuszika
 *
 */
public class Employee extends Person implements Comparable<Employee> {

	private String name;

	/**
	 * This method is the constructor for employees.
	 * 
	 * @param position
	 *            holds String value of the position occupied in the company
	 * @param seniority
	 *            holds value of the years active in the company
	 * @param name
	 *            holds the employee's name
	 */
	public Employee(String function, String position, int seniority, String name) {
		super(function, position, seniority);
		this.name = name;

	}

	List<Employee> noParkingPlace = new ArrayList<>();
	List<Employee> managerList = new ArrayList<>();
	List<Employee> engineerList = new ArrayList<>();

	public void showManagerList() {
		if (getFunction() != "Engineer") {
			managerList.add(new Employee(function, position, seniority, name));
			System.out.println(managerList);
		}
	}

	public void showEngineerList() {
		if (getFunction() == "Engineer") {
			engineerList.add(new Employee(function, position, seniority, name));
			System.out.println(engineerList);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void seniorityException() throws WrongSeniorityException {

		try {
			this.seniority = getSeniority();
			System.out.println();
			System.out.println("Got active years for: " + getName());

			int seniorityInMonths;
			seniorityInMonths = displayAgeInMonths(seniority);
			System.out.println("Active years [" + seniority + "] in months [" + seniorityInMonths + "]");
		} catch (WrongSeniorityException e) {
			System.out.println("Got an exception");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Numbers please!");
		} finally {
		}
		System.out.println("Ok!");
	}

	private int displayAgeInMonths(int seniority) throws WrongSeniorityException {
		if (seniority <= 0) {
			throw new WrongSeniorityException("Negative integers or 0 is not allowed!");
		}
		return seniority * 12;
	}

	/**
	 * Following method verifies if value of the seniority is bigger than 0.
	 * <p>
	 * It also checks the years spent in the company, based on the seniority (if
	 * more than 7) employee gets free parking space.
	 * 
	 * @throws WrongSeniorityException
	 *             checks if value of the seniority is bigger than 0
	 */
	public void showSeniority() {
		if (getSeniority() <= 0) {
		} else if (getSeniority() < 7) {
			noParkingPlace.add(new Employee(function, position, seniority, name));
			System.out.println(noParkingPlace);
		}
	}

	/**
	 * String method prints out the desired format of the employee list.
	 */
	@Override
	public String toString() {
		return "Employee - NAME = " + name + ", FUNCTION = " + function + ", POS. = " + position + ", YEARS = "
				+ seniority;
	}

	/**
	 * Compares employees active years in company and sorts them from youngest
	 * to oldest.
	 */
	@Override
	public int compareTo(Employee o) {
		if (this.seniority < o.getSeniority()) {
			return -1;
		}
		if (this.seniority > o.getSeniority()) {
			return 1;
		}
		return 0;
	}
}
