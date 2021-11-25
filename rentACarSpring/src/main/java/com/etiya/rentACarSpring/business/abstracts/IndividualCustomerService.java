package com.etiya.rentACarSpring.business.abstracts;

import java.util.List; 

import com.etiya.rentACarSpring.business.dtos.IndividualCustomerSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateIndividualCustomerRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteIndividualCustomerRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateIndividualCustomerRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
public interface IndividualCustomerService {

	DataResult<List<IndividualCustomerSearchListDto>> getAll();

	Result add(CreateIndividualCustomerRequest createIndividualCustomerRequest);

	Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

	Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest);
}
