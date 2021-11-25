package com.etiya.rentACarSpring.business.abstracts;

import java.util.List; 

import com.etiya.rentACarSpring.business.dtos.RentalSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateRentalRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteRentalRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateRentalRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface RentalService {

	DataResult<List<RentalSearchListDto>> getAll();
	Result add(CreateRentalRequest createRentalRequest);
	Result update(UpdateRentalRequest updateRentalRequest);
	Result delete(DeleteRentalRequest deleteRentalRequest);
}
