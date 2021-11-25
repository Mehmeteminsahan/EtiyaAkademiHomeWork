package com.etiya.rentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.business.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateCarRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteCarRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateCarRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetail;

public interface CarService {
	DataResult<List<CarSearchListDto>> getAll();
	//DataResult<List<CarDetail>> getByBrandName(String brandName);
	DataResult<List<CarDetail>> getCarWithBrandAndColorDetails();
	
	//CRUD operations
	Result add(CreateCarRequest createCarRequest);
	Result update(UpdateCarRequest updateCarRequest);
	Result delete(DeleteCarRequest deleteCarRequest);
}
