package eshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderDaoImpl extends AbstractModelDao implements OrderDao {

	private int id;
	private double value;
	private Date date;
	private boolean confirmed;
	private int customerId;
	private Connection conn;


	@Override
	protected Connection getDbConnection(String type, String host, int port, String dataBase, String user,
			String password) {
		return super.getDbConnection(type, host, port, dataBase, user, password);
	}

	public OrderDaoImpl() {
		conn = getDbConnection("postgresql", "localhost", 5432, "eshop", "postgres", "gyuszika1991");
	}

	public OrderDaoImpl(int id, double value, Date date, boolean confirmed, int customerId) {
		this.conn = getDbConnection("postgresql", "localhost", 5432, "eshop", "postgres", "gyuszika1991");
		this.id = id;
		this.value = value;
		this.date = date;
		this.confirmed = confirmed;
		this.customerId = customerId;

	}

	@Override
	public void createOrder(int id, double value, Date date, boolean confirmed, int customerId) {
		PreparedStatement ps = null;
		String sqlQuery = "INSERT INTO public.order(id, value, date, confirmed, id_customer) VALUES (" + id + ", " + value
				+ ", '" + date + "', " + confirmed + ", " + customerId + ")";

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

		final String format = "%10s%12s%20s%12s%12s\n";

		try {
			
			String sqlQuery = "SELECT * FROM public.order ";
			ps = conn.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			
			boolean hasResults = rs.next();
			if (hasResults) {

				System.out.format(format, "id", "value", "date", "confirmed", "customerId");
				do {
					System.out.format(format, rs.getInt("id"), rs.getDouble("value"), rs.getDate("date"),
							rs.getBoolean("confirmed"), rs.getInt("customerId"));
				} while (rs.next());

			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readOrder(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%20s%12s%12s\n";

		try {
			String sqlQuery = "SELECT * FROM public.order WHERE id=?";
			ps = conn.prepareStatement(sqlQuery);

			ps.setInt(1, id);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				this.id = rs.getInt("id");
				this.value = rs.getDouble("value");
				this.date = rs.getDate("date");
				this.confirmed = rs.getBoolean("confirmed");
				this.customerId = rs.getInt("customerId");
				System.out.format(format, id, value, date, confirmed, customerId);

			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int id) {
		PreparedStatement ps = null;
		String sqlQuery = "DELETE FROM public.order WHERE id=?";
		System.out.println(sqlQuery);
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.executeQuery();
		} catch (SQLException e) {
		}
	}
	

	public double getValue() {
		return value;
	}

	public Date getDate() {
		return date;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public int getCustomerId() {
		return customerId;
	}

	public Connection getConn() {
		return conn;
	}

}
