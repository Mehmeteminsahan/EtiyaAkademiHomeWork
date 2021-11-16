package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.dataAccess.abstracts.ProductRepository;
import northwind.entites.concretes.Product;

public class ProductDao implements ProductRepository {

	List<Product> products;
	
	public ProductDao() {
		 products = new ArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		products.add(product);
	}
	@Override
	public void delete(Product product) {
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return products;
	}

}
