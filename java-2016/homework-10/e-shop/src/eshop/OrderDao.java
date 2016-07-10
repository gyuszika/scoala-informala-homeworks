package eshop;

import java.util.Date;

public interface OrderDao {

	void createOrder(int id, double value, Date date, boolean confirmed, int customerId);

	void readAll();

	void readOrder(int id);

	void deleteOrder(int id);
}
