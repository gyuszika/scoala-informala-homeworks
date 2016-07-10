package eshop;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		loadDriver();
		CustomerDaoImpl customer = new CustomerDaoImpl();
		if (customer.getConn() == null)
			return;
		
		OrderDaoImpl order = new OrderDaoImpl();
		if (order.getConn() == null)
			return;
		
		OrderItemsDaoImpl orderItems = new OrderItemsDaoImpl();
		if (orderItems.getConn() == null)
			return;
		
		ProductDaoImpl product = new ProductDaoImpl();
		if(product.getConn() == null)
			return;
		
		product.createProduct(2, "Ronaldo", "the 2nd best product");
		product.readAll();
		
	}

	public static void loadDriver() {

		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
