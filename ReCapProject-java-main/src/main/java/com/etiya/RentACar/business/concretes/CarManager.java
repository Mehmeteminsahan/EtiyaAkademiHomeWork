package com.etiya.RentACar.business.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.etiya.RentACar.business.abstracts.BrandService;
import com.etiya.RentACar.business.abstracts.CarImageService;
import com.etiya.RentACar.business.abstracts.CarService;
import com.etiya.RentACar.business.abstracts.ColorService;
import com.etiya.RentACar.business.constants.FilePathConfiguration;
import com.etiya.RentACar.business.constants.Messages;
import com.etiya.RentACar.business.dtos.CarDetailDto;
import com.etiya.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACar.business.requests.car.CreateCarRequest;
import com.etiya.RentACar.business.requests.car.DeleteCarRequest;
import com.etiya.RentACar.business.requests.car.UpdateCarRequest;
import com.etiya.RentACar.core.utilities.business.BusinessRules;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.core.utilities.results.ErrorDataResult;
import com.etiya.RentACar.core.utilities.results.ErrorResult;
import com.etiya.RentACar.core.utilities.results.Result;
import com.etiya.RentACar.core.utilities.results.SuccessDataResult;
import com.etiya.RentACar.core.utilities.results.SuccessResult;
import com.etiya.RentACar.dataAccess.abstracts.CarDao;
import com.etiya.RentACar.entites.Car;
import com.etiya.RentACar.entites.CarImage;
import com.etiya.RentACar.entites.ComplexTypes.CarDetail;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;
	private CarImageService carImageService;
	private BrandService brandService;
	private ColorService colorService;

	@Autowired
	private CarManager(CarDao carDao, ModelMapperService modelMapperService,@Lazy CarImageService carImageService,
			BrandService brandService, ColorService colorService) {
		super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
		this.carImageService = carImageService;
		this.brandService = brandService;
		this.colorService = colorService;

	}

	@Override
	public DataResult<List<CarSearchListDto>> getAll() {
		List<Car> result = this.carDao.findAll();

		List<CarSearchListDto> response = result.stream()
				.map(car -> modelMapperService.forDto().map(car, CarSearchListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<CarSearchListDto>>(response, Messages.ListedCar);
	}

	@Override
	public DataResult<List<CarSearchListDto>> getAllAvailableCars() {
		List<CarSearchListDto> allCars = getAll().getData();

		return new SuccessDataResult<List<CarSearchListDto>>(allCars, "Bakımda olmayan arabalar listelendi");
	}

	@Override
	public Result save(CreateCarRequest createCarRequest) {

		Result result = BusinessRules
				.run(checkBrandExists(createCarRequest.getBrandId()),checkColorExists(createCarRequest.getColorId()));

		if (result != null) {
			return result;
		}

		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		Random random = new Random();
		car.setMinFindeksScore(random.nextInt(1900));
		this.carDao.save(car);
		return new SuccessResult(Messages.AddedCar);
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Result result = BusinessRules.run(
				checkBrandExists(updateCarRequest.getBrandId())
				,checkColorExists(updateCarRequest.getColorId()),
				checkCarExists(updateCarRequest.getCarId()));

		if (result != null) {
			return result;
		}
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		carDao.save(car);
		return new SuccessResult(Messages.UpdatedCar);
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		Result result = BusinessRules.run(checkCarExists(deleteCarRequest.getCarId()));

		if (result != null) {
			return result;
		}
		Car car = modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		carDao.delete(car);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CarDetail>> getCarsWithBrandAndColorDetails() {
		List<CarDetail> result = this.carDao.getCarWithBrandAndColorDetails();
		return new SuccessDataResult<List<CarDetail>>(result);
	}

	@Override
	public DataResult<List<CarDetail>> getCarByBrandId(int brandId) {
		Result resultcheck = BusinessRules.run(checkBrandExists(brandId));

		if (resultcheck != null) {
			return new ErrorDataResult<List<CarDetail>>(null,"brand Bulunamadı");
		}
		List<Car> result = this.carDao.getByBrand_brandId(brandId);
		List<CarDetail> response = result.stream().map(car -> modelMapperService.forDto().map(car, CarDetail.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CarDetail>>(response);
	}

	@Override
	public DataResult<List<CarDetail>> getCarByColorId(int colorId) {
		Result resultcheck = BusinessRules.run(checkColorExists(colorId));

		if (resultcheck != null) {
			return new ErrorDataResult<List<CarDetail>>(null,"Color Bulunamadı");
		}
		List<Car> result = this.carDao.getByColor_colorId(colorId);
		List<CarDetail> response = result.stream().map(car -> modelMapperService.forDto().map(car, CarDetail.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CarDetail>>(response);
	}

	@Override
	public DataResult<CarSearchListDto> getById(int carId) {

		Car car = this.carDao.findById(carId).get();

		if (car != null) {
			CarSearchListDto carSearchListDto = modelMapperService.forDto().map(car, CarSearchListDto.class);
			return new SuccessDataResult<CarSearchListDto>(carSearchListDto);
		}
		return null;
	}

	@Override
	public DataResult<List<CarDetailDto>> getByCarAllDetail(int carId) {
		Result result = BusinessRules.run(checkCarExists(carId));
		if (result != null) {
			return new ErrorDataResult<List<CarDetailDto>>(null, "Araba bulunamadı");
		}

		Car cars = this.carDao.getById(carId);
		List<CarDetailDto> carDetailDtos = new ArrayList<CarDetailDto>();
		CarDetailDto carDetailDto = modelMapperService.forDto().map(cars, CarDetailDto.class);
		carDetailDto.setCarImagesDetail(this.carImageService.getCarImageByCarId(cars.getId()).getData());
		carDetailDtos.add(carDetailDto);
		return new SuccessDataResult<List<CarDetailDto>>(carDetailDtos, "Araç detayları listelendi");

	}

	@Override
	public Result checkCarExists(int carId) {
		if (!this.carDao.existsById(carId)) {
			return new ErrorResult("araba bulunamadı");
		}
		return new SuccessResult();

	}

	
	private Result checkColorExists(int colorId) {
		if(!this.colorService.existsByColor_Id(colorId).isSuccess()) {
			return new ErrorResult("color bulunamadı");
		}
		return new SuccessResult();
	}
	
	private Result checkBrandExists(int brandId) {
		if (!this.brandService.existsByBrand_Id(brandId).isSuccess()) {
			return new ErrorResult("brand yada color bulunamdı");
		}
		return new SuccessResult();
	}

}
