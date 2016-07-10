package eshop;

public interface ProductDao {

	void createProduct(int id, String name, String description);

	void readAll();

	void readProduct(int id);

	void deleteProduct(int id);

}
