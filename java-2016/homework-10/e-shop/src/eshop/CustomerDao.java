package eshop;

public interface CustomerDao {

	void createCustomer(int id, String name, String email);

	void readAll();

	void readCustomer(int id);

	void deleteCustomer(int id);

}
