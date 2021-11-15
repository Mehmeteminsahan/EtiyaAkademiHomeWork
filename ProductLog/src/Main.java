
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductManager productManager = new ProductManager(null);
		productManager.save(null);
		productManager.add(new FileLogger());
		productManager.add(new DbLogger());
		Logger logger = new Logger();
		logger.log();
		Logger[] loggers = {new FileLogger(), new DbLogger()};
		productManager.addMultiple(loggers);
	}
	

}
