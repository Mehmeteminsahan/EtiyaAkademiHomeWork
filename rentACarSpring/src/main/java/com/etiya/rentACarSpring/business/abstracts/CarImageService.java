package com.etiya.rentACarSpring.business.abstracts;

import java.io.IOException;
import java.util.List;

import com.etiya.rentACarSpring.business.dtos.CarImageDto;
import com.etiya.rentACarSpring.business.dtos.CarImageSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateCarImageRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteCarImageRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateCarImageRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface CarImageService {
	
	DataResult<List<CarImageSearchListDto>> getAll();
	Result add(CreateCarImageRequest createCarImageRequest) throws IOException;
	Result update(UpdateCarImageRequest updateCarImageRequest)throws IOException;
	Result delete(DeleteCarImageRequest deleteCarImageRequest);
	DataResult<List<CarImageDto>> carImagesByCarId(int carId);

}
