package companyemployees;

/**
 * This is an abstract parent class containing the position, function and seniority
 * fields.
 * 
 * @author Gyuszika
 *
 */
public abstract class Person {

	protected String position;
	protected int seniority;
	protected String function;

	public String getPosition() {
		return position;
	}

	public String getFunction() {
		return function;
	}

	public void setFuntion(String function) {
		this.function = function;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public Person(String function, String position, int seniority) {
		this.function = function;
		this.position = position;
		this.seniority = seniority;
	}

}
