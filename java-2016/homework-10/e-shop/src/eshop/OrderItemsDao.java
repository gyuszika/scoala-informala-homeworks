package eshop;

import java.util.Date;

public interface OrderItemsDao {
	
	void createOrderItems(int id, int orderId, int quantity, int productId);

	void readAll();

	void readOrderItems(int id);

	void deleteOrderItems(int id);
}
