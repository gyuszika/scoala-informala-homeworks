package companyemployees;

import java.util.ArrayList;
import java.util.List;

/**
 * This Person class is a child class of Employee, allowing to create the person
 * list containing Name, company position and active years.
 * 
 * @author Gyuszika
 *
 */
public class Person extends Employee implements Comparable<Person> {

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
	public Person(String function, String position, int seniority, String name) {
		super(function, position, seniority);
		this.name = name;

	}

	List<Person> noParkingPlace = new ArrayList<>();
	List<Person> managerList = new ArrayList<>();
	List<Person> engineerList = new ArrayList<>();

	public void showManagerList() {
		if (getFunction() != "Engineer") {
			managerList.add(new Person(function, position, seniority, name));
			System.out.println(managerList);
		}
	}

	public void showEngineerList() {
		if (getFunction() == "Engineer") {
			engineerList.add(new Person(function, position, seniority, name));
			System.out.println(engineerList);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public void showSeniority() throws WrongSeniorityException {
		if (getSeniority() <= 0) {
			throw new WrongSeniorityException("Active working years should be more than 0");
		} else if (getSeniority() < 7) {
			noParkingPlace.add(new Person(function, position, seniority, name));
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
	public int compareTo(Person o) {
		if (this.seniority < o.getSeniority()) {
			return -1;
		}
		if (this.seniority > o.getSeniority()) {
			return 1;
		}
		return 0;
	}
}
