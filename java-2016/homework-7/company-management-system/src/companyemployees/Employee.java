package companyemployees;
/**
 * This is an abstract parent class containing the position and seniority fields.
 * @author Gyuszika
 *
 */
public abstract class Employee {

	protected String position;
	protected int seniority;

	public String getPosition() {
		return position;
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

	public Employee(String position, int seniority) {
		this.position = position;
		this.seniority = seniority;
	}

}
