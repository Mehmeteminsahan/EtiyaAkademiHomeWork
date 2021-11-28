package com.etiya.RentACar.business.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.RentACar.business.abstracts.CarImageService;
import com.etiya.RentACar.business.constants.FilePathConfiguration;
import com.etiya.RentACar.business.dtos.CarImagesDto;
import com.etiya.RentACar.business.dtos.CarImagesSearchListDto;
import com.etiya.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACar.business.requests.carImages.CreateCarImageRequest;
import com.etiya.RentACar.business.requests.carImages.DeleteCarImagesRequest;
import com.etiya.RentACar.business.requests.carImages.UpdateCarImageRequest;
import com.etiya.RentACar.core.utilities.Message.Messages;
import com.etiya.RentACar.core.utilities.business.BusinessRules;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.core.utilities.results.ErrorResult;
import com.etiya.RentACar.core.utilities.results.Result;
import com.etiya.RentACar.core.utilities.results.SuccessDataResult;
import com.etiya.RentACar.core.utilities.results.SuccessResult;
import com.etiya.RentACar.dataAccess.abstracts.CarImageDao;
import com.etiya.RentACar.entites.Car;
import com.etiya.RentACar.entites.CarImage;

@Service
public class CarImageManager implements CarImageService {

	private CarImageDao carImageDao;
	private ModelMapperService modelMapperService;

	@Autowired
	private CarImageManager(CarImageDao carImageDao, ModelMapperService modelMapperService) {
		super();
		this.carImageDao = carImageDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarImagesSearchListDto>> getAll() {
		List<CarImage> carImages = this.carImageDao.findAll();
		List<CarImagesSearchListDto> result = carImages.stream()
				.map(carImage -> modelMapperService.forDto().map(carImage, CarImagesSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CarImagesSearchListDto>>(result, "Araba resimleri listelendi");
	}

	@Override
	public Result add(CreateCarImageRequest createCarImageRequest) throws IOException {
		Result result = BusinessRules.run(checkNumberOfCarImages(createCarImageRequest.getCarId()));
		if (result != null) {
			return result;
		}
		CarImage carImage = modelMapperService.forRequest().map(createCarImageRequest, CarImage.class); //
		carImage.setImageDate(LocalDate.now());
		
		carImage.setImagePath(generateImage(createCarImageRequest.getFile()).toString());
		this.carImageDao.save(carImage);
		return new SuccessResult("araba resmi eklendi");
	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) throws IOException {
		CarImage carImage = modelMapperService.forRequest().map(updateCarImageRequest, CarImage.class); //
		carImage.setImageDate(LocalDate.now());
		carImage.setImagePath(generateImage(updateCarImageRequest.getFile()).toString());
		this.carImageDao.save(carImage);
		return new SuccessResult("Araba güncellendi");

	}

	@Override
	public Result delete(DeleteCarImagesRequest deleteCarImagesRequest) {
		CarImage carImage = this.carImageDao.getById(deleteCarImagesRequest.getId());
		this.carImageDao.delete(carImage);
		return new SuccessResult("Araba silindi");
	}

	private File generateImage(MultipartFile file) throws IOException {

		String imagePathGuid = java.util.UUID.randomUUID().toString(); // yeni bir guid oluşturduk. ve değişkene atadık.

		File imageFile = new File("C:\\Users\\erdi.tuna\\Downloads\\ReCapProject-java-main\\ReCapProject-java-main\\image\\" + imagePathGuid + "."
				+ file.getContentType().substring(file.getContentType().indexOf("/") + 1));

		imageFile.createNewFile();
		FileOutputStream outputImage = new FileOutputStream(imageFile);
		outputImage.write(file.getBytes());
		outputImage.close();

		return imageFile;
	}

	private Result checkNumberOfCarImages(int carId) {
		if (this.carImageDao.countCarImageByCar_Id(carId) >= 5) {
			return new ErrorResult("Araba mevcut halde 5 tane fotoğraf içeriyor");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CarImagesDto>> CarImagesByCarId(int carId) {

		if (this.carImageDao.getByCar_Id(carId).isEmpty()) {

			CarImagesDto carImage = new CarImagesDto();
			carImage.setImagePath(FilePathConfiguration.mainPath + FilePathConfiguration.defaultImage);
			carImage.setDate(LocalDate.now());
			List<CarImagesDto> carImages = new ArrayList<CarImagesDto>();
			carImages.add(carImage);
			return new SuccessDataResult<List<CarImagesDto>>(carImages);
		}

		List<CarImage> carImages = this.carImageDao.getByCar_Id(carId);
		List<CarImagesDto> result = carImages.stream()
				.map(carImage -> modelMapperService.forDto().map(carImage, CarImagesDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult(result);
	}
	
	@Override
	public Result checkIfCarImageExist(int carId) {
		if (this.carImageDao.getByCar_Id(carId).isEmpty()) {
			return new ErrorResult();
		}
		return new SuccessResult();
			
	}

	@Override
	public List<CarImage> getCarImageListByCarId(int carId) {
		// TODO Auto-generated method stub
		return this.carImageDao.getByCar_Id(carId);
	}
	
	

}
