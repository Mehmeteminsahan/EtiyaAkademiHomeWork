package northwind.business.concretes;

import java.util.List;

import northwind.business.abstracts.ProductService;
import northwind.dataAccess.abstracts.ProductRepository;
import northwind.entites.concretes.Product;

public class ProductManager implements ProductService {

	private ProductRepository productRepository;

	public ProductManager(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return this.productRepository.getAll();
	}

	@Override
	public void add(Product product) {
		

		if (checkProductName(product)&&checkUnitPrice(product)&&checkbyCategoryIdandUnitPrice(product)
				&&checkCategoryCount(product)) {
			this.productRepository.add(product);
		}

	}

	private boolean checkCategoryCount(Product product) {
		int count = 0;
		for (Product productin : getAll()) {
			if (product.getCategoryId() == productin.getCategoryId()) {
				count++;
			}
			if(count>5) {
				System.out.println("aynı kategoriden 4 den fazla eklenemez");
				return false;
			}
		}
		return true;
	}

	private boolean checkbyCategoryIdandUnitPrice(Product product) {

		if (product.getCategoryId() == 3 && product.getUnitPrice() < 10) {
			System.out.println("Category Id 3 olan ürün fiyatı 10 dan küçük olamaz");
			return false;
		}
		return true;
	}

	private boolean checkUnitPrice(Product product) {
		if (product.getUnitPrice() < 0) {
			System.out.println("ürün fiyatı negatif olamaz");
			return false;
		}
		return true;
	}

	private boolean checkProductName(Product product) {

		for (Product item : getAll()) {
			if (product.getProductName() == item.getProductName()) {
				System.out.println("aynı isimden ürün eklenemez");
				return false;
			}
		}
		return true;
	}

}
