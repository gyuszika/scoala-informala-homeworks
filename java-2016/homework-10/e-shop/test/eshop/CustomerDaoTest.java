package eshop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerDaoTest {
	
	public static final int ENTITY_ID = 6;

	@Test

	public void customerTest() {
		CustomerDaoImpl customer = new CustomerDaoImpl();
		customer.readCustomer(ENTITY_ID);
		assertEquals("Gyuszika", customer.getName());
		assertEquals("szapora_gyuszika@yahoo.com", customer.getEmail());
	}
	
	@Test

	public void customerTestCreate() {
		CustomerDaoImpl customer = new CustomerDaoImpl();
		customer.createCustomer(ENTITY_ID, "ba", "blalba");
		customer.readCustomer(ENTITY_ID);
		assertEquals("ba", customer.getName());
		assertEquals("blalba", customer.getEmail());
	}
	

}
