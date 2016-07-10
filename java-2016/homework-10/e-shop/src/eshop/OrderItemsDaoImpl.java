package eshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemsDaoImpl extends AbstractModelDao implements OrderItemsDao {
	
	private int id;
	private int orderId;
	private int quantity;
	private int productId;
	private Connection conn;
	
	public OrderItemsDaoImpl(int id, int orderId, int quantity, int productId) {
		this.conn = getDbConnection("postgresql", "localhost", 5432, "eshop", "postgres", "gyuszika1991");
		this.id = id;
		this.orderId = orderId;
		this.quantity = quantity;
		this.productId = productId;
	}
	

	public OrderItemsDaoImpl() {
		conn = getDbConnection("postgresql", "localhost", 5432, "eshop", "postgres", "gyuszika1991");
	}
	
	@Override
	protected Connection getDbConnection(String type, String host, int port, String dataBase, String user,
			String password) {
		return super.getDbConnection(type, host, port, dataBase, user, password);
	}

	@Override
	public void createOrderItems(int id, int orderId, int quantity, int productId) {
		PreparedStatement ps = null;
		String sqlQuery = "INSERT INTO orderitems(id, orderId, quantity, productId) VALUES (" + id + ", " + orderId + ", " + quantity + ", " + productId + ")";

		System.out.println(sqlQuery);
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.executeQuery();
		} catch (SQLException e) {
		}
	}

	@Override
	public void readAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%12s%12s\n";

		try {
			
			String sqlQuery = "SELECT * FROM public.orderitems ";
			ps = conn.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			
			boolean hasResults = rs.next();
			if (hasResults) {

				System.out.format(format, "id", "orderId", "quantity", "productId" );
				do {
					System.out.format(format, rs.getInt("id"), rs.getInt("orderId"), rs.getInt("quantity"),
							rs.getInt("productId"));
				} while (rs.next());

			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readOrderItems(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%12s%12s\n";

		try {
			String sqlQuery = "SELECT * FROM public.orderitems WHERE id=?";
			ps = conn.prepareStatement(sqlQuery);

			ps.setInt(1, id);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				this.id = rs.getInt("id");
				this.orderId = rs.getInt("orderId");
				this.quantity = rs.getInt("quantity");
				this.productId = rs.getInt("productId");
				System.out.format(format, id, orderId, quantity, productId);

			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderItems(int id) {
		PreparedStatement ps = null;
		String sqlQuery = "DELETE FROM orderitems WHERE id=?";
		System.out.println(sqlQuery);
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.executeQuery();
		} catch (SQLException e) {
		}
	}
	
	public int getOrderId() {
		return orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getProductId() {
		return productId;
	}
	
	public Connection getConn() {
		return conn;
	}

	

}
