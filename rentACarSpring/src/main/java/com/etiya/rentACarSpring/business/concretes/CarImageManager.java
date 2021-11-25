package com.etiya.rentACarSpring.business.concretes;

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

import com.etiya.rentACarSpring.business.abstracts.CarImageService;
import com.etiya.rentACarSpring.business.constants.FilePathConfiguration;
import com.etiya.rentACarSpring.business.dtos.CarImageDto;
import com.etiya.rentACarSpring.business.dtos.CarImageSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateCarImageRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteCarImageRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateCarImageRequest;
import com.etiya.rentACarSpring.core.utilities.business.BusinessRules;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.ErrorResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccessDataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccessResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.CarImageDao;
import com.etiya.rentACarSpring.entities.CarImage;


@Service
public class CarImageManager implements CarImageService{

	private CarImageDao carImageDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarImageManager(CarImageDao carImageDao, ModelMapperService modelMapperService) {
		this.carImageDao = carImageDao;
		this.modelMapperService = modelMapperService;
	}

	
	@Override
	public DataResult<List<CarImageSearchListDto>> getAll() {
      List<CarImage> result = this.carImageDao.findAll();
		
		//Veri tablosundaki veriyi ilgili dto'ya mapledik.
		List<CarImageSearchListDto> response = result.stream().map(carImage -> modelMapperService.forDto()
				.map(carImage, CarImageSearchListDto.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CarImageSearchListDto>>(response, "Resim Listelendi");
	}


	@Override
	public Result add(CreateCarImageRequest createCarImageRequest) throws IOException {
		
		Result result=BusinessRules.run(checkCarImagesCount(createCarImageRequest.getCarId()));
		 
		if(result!=null) {
			return result;
		}
		
		CarImage carImage = modelMapperService.forRequest().map(createCarImageRequest, CarImage.class);
		carImage.setDate(LocalDate.now());
		carImage.setImagePath(generateImage(createCarImageRequest.getFile()).toString());
		this.carImageDao.save(carImage);
		return new SuccessResult("The vehicle has been added.");
	}


	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) throws IOException{
		
		
		CarImage carImage = modelMapperService.forRequest().map(updateCarImageRequest, CarImage.class);
		
		
		carImage.setDate(LocalDate.now());
		carImage.setImagePath(generateImage(updateCarImageRequest.getFile()).toString());
		this.carImageDao.save(carImage);
		return new SuccessResult("The vehicle has been updated.");
	}


	@Override
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		this.carImageDao.deleteById(deleteCarImageRequest.getId());
		return new SuccessResult("The vehicle has been deleted.");
	}

	
	private File generateImage(MultipartFile file) throws IOException {
		
		String imagePathGuid = java.util.UUID.randomUUID().toString();
		File imageFile = new File(FilePathConfiguration.mainPath+imagePathGuid+"."+
		file.getContentType().substring(file.getContentType().indexOf("/")+1));
		
		imageFile.createNewFile();
		FileOutputStream outputImage = new FileOutputStream(imageFile);
		
		outputImage.write(file.getBytes());
		outputImage.close();
		return imageFile;		
	}
	
	private Result checkCarImagesCount(int carId) {
		
		if(carImageDao.countCarImageByCar_Id(carId)>=5) {
			return new ErrorResult("5 den fazla resim olamaz");
		}
	
		return new SuccessResult();
	}
	
	public DataResult<List<CarImageDto>> carImagesByCarId(int carId) {
		
		
		
		if(this.carImageDao.getByCar_Id(carId).isEmpty()) {
			CarImageDto carImage = new CarImageDto();
            carImage.setImagePath(FilePathConfiguration.mainPath+FilePathConfiguration.defaultImage);
            carImage.setDate(LocalDate.now());
            List<CarImageDto> carImages = new ArrayList<CarImageDto>();
            carImages.add(carImage);
            return new SuccessDataResult<List<CarImageDto>>(carImages);	
			
		}
		List<CarImage> carImages = this.carImageDao.getByCar_Id(carId);
        List<CarImageDto> result = carImages.stream()
                .map(carImage -> modelMapperService.forDto().map(carImage, CarImageDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<CarImageDto>>(result);
		
	}

}
