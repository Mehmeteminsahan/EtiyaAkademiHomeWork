package com.etiya.RentACar.business.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACar.business.abstracts.CarImageService;
import com.etiya.RentACar.business.abstracts.CarService;
import com.etiya.RentACar.business.constants.FilePathConfiguration;
import com.etiya.RentACar.business.dtos.CarDetailDto;
import com.etiya.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACar.business.requests.car.CreateCarRequest;
import com.etiya.RentACar.business.requests.car.DeleteCarRequest;
import com.etiya.RentACar.business.requests.car.UpdateCarRequest;
import com.etiya.RentACar.core.utilities.Message.Messages;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
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

	@Autowired
	private CarManager(CarDao carDao, ModelMapperService modelMapperService, CarImageService carImageService) {
		super();
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
		this.carImageService = carImageService;

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
		List<CarSearchListDto> result = this.carDao.getCarsMaintenanceReturnDateIsNull();
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < allCars.size(); j++) {
				if (result.get(i).getCarId() == allCars.get(j).getCarId() ) {
					allCars.remove(j);
				}
			}
		}
		return new SuccessDataResult<List<CarSearchListDto>>(allCars,"Bakımda olmayan arabalar listelendi");
	}

	@Override
	public Result save(CreateCarRequest createCarRequest) {
		Car result = modelMapperService.forRequest().map(createCarRequest, Car.class);
		Random random = new Random();
		result.setMinFindeksSCore(random.nextInt(1900));
		this.carDao.save(result);
		return new SuccessResult(Messages.AddedCar);
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		carDao.save(car);
		return new SuccessResult(Messages.UpdatedCar);
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
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
		List<Car> result = this.carDao.getByBrand_brandId(brandId);
		List<CarDetail> response = result.stream().map(car -> modelMapperService.forDto().map(car, CarDetail.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CarDetail>>(response);
	}

	@Override
	public DataResult<List<CarDetail>> getCarByColorId(int colorId) {
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
	public DataResult<CarDetailDto> getByCarAllDetail(int carId) {

		Car car = this.carDao.getById(carId);
		CarDetailDto carDetailDto = modelMapperService.forDto().map(car, CarDetailDto.class);
		List<String> list = new ArrayList<String>();
		for (CarImage image : carImageService.getCarImageListByCarId(carId)) {
			list.add(image.getImagePath());
		}
		if (list.size() == 0) {
			list.add(FilePathConfiguration.mainPath + FilePathConfiguration.defaultImage);
			carDetailDto.setImagePaths(list);
			return new SuccessDataResult<CarDetailDto>(carDetailDto);
		} else {
			carDetailDto.setImagePaths(list);
			return new SuccessDataResult<CarDetailDto>(carDetailDto);
		}

//		if(this.carImageService.checkIfCarImageExist(carId).isSuccess() == false) {
//			
//			CarDetailDto carDetail = new CarDetailDto();
//			CarImageDetail carImageDetail  = new CarImageDetail();
//			carImageDetail.setImagePath(FilePathConfiguration.mainPath+FilePathConfiguration.defaultImage);
//			List<CarImageDetail> carImageDetails = new ArrayList<CarImageDetail>();
//			carImageDetails.add(carImageDetail);
//			carDetail.setCarImageDetail(carImageDetails);
//		
//		
//			List<CarDetailDto> carDetails = new ArrayList<CarDetailDto>();
//			carDetails.add(carDetail);
//			
//			return new SuccessDataResult<List<CarDetailDto>>(carDetails);
//			
//	}
//		
//		List<Car> result = this.carDao.getById(carId);
//	
//		List<CarDetailDto> response = result.stream()
//				.map(car -> modelMapperService.forDto().map(car, CarDetailDto.class)).collect(Collectors.toList());
//		return new SuccessDataResult<List<CarDetailDto>>(response);
//	
//	
//	}
	}

}
