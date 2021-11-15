
public class ProductManager implements ProductService {
	private ProductDao productDao;

	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		System.out.println("Veri Tabanina Kaydedildi.");

	}

	@Override
	public void add(Logger logger) {
		// TODO Auto-generated method stub
		logger.log();
	}

	public void addMultiple(Logger[] loggers) {
		for (Logger logger : loggers) {
			add(logger);
		}
	}

}
