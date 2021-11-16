package northwind;

import northwind.business.abstracts.CategoryService;
import northwind.business.abstracts.EmployeeService;
import northwind.business.abstracts.ProductService;
import northwind.business.concretes.CategoryManager;
import northwind.business.concretes.EmployeeManager;
import northwind.business.concretes.ProductManager;
import northwind.dataAccess.concretes.CategoryDao;
import northwind.dataAccess.concretes.EmployeeDao;
import northwind.dataAccess.concretes.ProductDao;
import northwind.entites.concretes.Employee;
import northwind.entites.concretes.Product;

public class Main {

	public static void main(String[] args) {

		ProductService productService = new ProductManager(new ProductDao());
		productService.add(new Product(1, 1, "Elma", 10));
		
		productService.add(new Product(3, 1, "Karpuz", 30));
		productService.add(new Product(4, 1, "üzüm", 40));
		productService.add(new Product(5, 3, "incir", 5));
		productService.add(new Product(6, 1, "Kiraz", 50));
		productService.add(new Product(2, 1, "Elma", 20));
		productService.add(new Product(7, 1, "Kavun", 50));
		productService.add(new Product(7, 1, "ekstras", 50));
		productService.add(new Product(8, 3, "Muz", 15));
		productService.add(new Product(9, 2, "ejder Meyvesi", -5));
		for (Product product : productService.getAll()) {
			System.out.println(product.getProductName());
		}

		//CategoryService categoryService = new CategoryManager(new CategoryDao());
		
		EmployeeService employeeService = new EmployeeManager(new EmployeeDao());
		
		for (Employee employee : employeeService.getAll()) {
			System.out.println(employee.getFirstName());
		}
		
	}
}
