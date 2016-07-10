package eshop;

import java.sql.Connection;

public abstract class AbstractModelDao {

	protected Connection getDbConnection(String type, String host, int port, String dataBase, String user,
			String password){
		return ConnectionManager.getConnection(type, host, port, dataBase, user, password);
	}
}
