package eshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl extends AbstractModelDao implements ProductDao {

	private int id;
	private String name;
	private String description;
	private Connection conn;

	@Override
	protected Connection getDbConnection(String type, String host, int port, String dataBase, String user,
			String password) {
		return super.getDbConnection(type, host, port, dataBase, user, password);
	}

	public ProductDaoImpl() {
		conn = getDbConnection("postgresql", "localhost", 5432, "eshop", "postgres", "gyuszika1991");
	}

	public ProductDaoImpl(int id, String name, String description) {
		this.conn = getDbConnection("postgresql", "localhost", 5432, "eshop", "postgres", "gyuszika1991");
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public void createProduct(int id, String name, String description) {
		PreparedStatement ps = null;
		String sqlQuery = "INSERT INTO public.products(id, name, description) VALUES (" + id + ", '" + name+ "', '" + description + "')";

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

		final String format = "%10s%12s%20s\n";

		try {
			String sqlQuery = "SELECT * FROM public.products";
			ps = conn.prepareStatement(sqlQuery);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				System.out.format(format, "id", "name", "description");
				do {
					System.out.format(format, rs.getInt("id"), rs.getString("name"), rs.getString("description"));
				} while (rs.next());

			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readProduct(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%20s\n";

		try {
			String sqlQuery = "SELECT * FROM public.products WHERE id=?";
			ps = conn.prepareStatement(sqlQuery);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				this.id = rs.getInt("id");
				this.name = rs.getString("name");
				this.description = rs.getString("email");
				System.out.format(format, id, name, description);

			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int id) {
		PreparedStatement ps = null;
		String sqlQuery = "DELETE FROM public.products WHERE id=?";
		System.out.println(sqlQuery);
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.executeQuery();
		} catch (SQLException e) {
		}
	}

	public Connection getConn() {
		return conn;
	}

}
