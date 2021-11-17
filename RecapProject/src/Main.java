import bussiness.abstracts.BrandService;
import bussiness.abstracts.CarService;
import bussiness.abstracts.ColorService;
import bussiness.concretes.BrandManager;
import bussiness.concretes.CarManager;
import bussiness.concretes.ColorManager;
import dataAccess.concretes.BrandDao;
import dataAccess.concretes.CarDao;
import dataAccess.concretes.ColorDao;
import entities.concretes.Brand;
import entities.concretes.Car;
import entities.concretes.Color;

public class Main {

	public static void main(String[] args) {
		CarService carService = new CarManager(new CarDao());
		carService.add(new Car(1001,1,1,1998,250,"Sahibinden"));
		carService.add(new Car(1002,2,3,1964,1000,"Keyfe keder"));
		carService.add(new Car(1003,2,2,2011,350,"Yazılımcıdan"));
		carService.delete(1001);
		carService.update(1003, new Car(1003,2,2,2011,350,"Doktordan"));
		System.out.println(	carService.getById(1003).getData().getDescription());

		
		for(Car car : carService.getAll().getData()) {
			System.out.println(car.getDescription());
		}
		
		ColorService colorService = new ColorManager(new ColorDao());
		colorService.add(new Color(1,"Kırmızı"));
		colorService.add(new Color(2,"Siyah"));
		colorService.add(new Color(3,"Beyaz"));
		colorService.delete(2);
		colorService.update(3, new Color(3,"Mavi"));

		
		for(Color color : colorService.getAll().getData()) {
			System.out.println(color.getColarName());
		}
		
		BrandService brandService = new BrandManager(new BrandDao());
		brandService.add(new Brand(1,"Fiat"));
		brandService.add(new Brand(2,"Chevrolet"));
		brandService.add(new Brand(3,"BMW"));
		brandService.delete(3);
		brandService.update(1, new Brand(1,"Tofaş"));
		
		for(Brand brand : brandService.getAll().getData()) {
			System.out.println(brand.getBrandName());
		}
		

	}
}
