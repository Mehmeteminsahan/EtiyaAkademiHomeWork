package com.etiya.rentACarSpring.ws;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.rentACarSpring.business.abstracts.CarImageService;
import com.etiya.rentACarSpring.business.dtos.CarImageDto;
import com.etiya.rentACarSpring.business.dtos.CarImageSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateCarImageRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteCarImageRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateCarImageRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

@RestController
@RequestMapping("api/carimages")
public class CarImagesController {
	
private CarImageService carImageService;
	
	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}

	
	//Controller'da entities ile çalışılmaz. Dto [Data Transfer Object] kullanılır.
	@GetMapping("all")
	public DataResult<List<CarImageSearchListDto>> getAll(){
		return this.carImageService.getAll();
	}
	
	
	@GetMapping("getCarImagesByCarId")
    public DataResult<List<CarImageDto>> getCarImagesByCarId(int carId) {
        return this.carImageService.carImagesByCarId(carId);
    }
		
	@PostMapping("add")
    public Result add(@RequestParam("carId") int carId, MultipartFile file) throws IOException {

        CreateCarImageRequest createCarImageRequest = new CreateCarImageRequest();
        createCarImageRequest.setCarId(carId);
        createCarImageRequest.setFile(file);

        return this.carImageService.add(createCarImageRequest);
    }
	
	@PutMapping("/update")
    public Result update(@RequestParam("carImageId") int carImageId, @RequestParam("file") MultipartFile file,@RequestParam("carId") int carId)
            throws IOException {

        UpdateCarImageRequest updateCarImageRequest = new UpdateCarImageRequest();
        updateCarImageRequest.setCarId(carId);
        updateCarImageRequest.setCarImageId(carImageId);
        updateCarImageRequest.setFile(file);

        return this.carImageService.update(updateCarImageRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@Valid DeleteCarImageRequest deleteCarImageRequest) {
        return this.carImageService.delete(deleteCarImageRequest);
    }

}
