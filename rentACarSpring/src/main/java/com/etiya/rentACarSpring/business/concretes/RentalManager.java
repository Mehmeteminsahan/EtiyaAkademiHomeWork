package com.etiya.rentACarSpring.business.concretes;

import java.util.List; 
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.business.abstracts.RentalService;
import com.etiya.rentACarSpring.business.dtos.RentalSearchListDto;

import com.etiya.rentACarSpring.business.requests.creates.CreateRentalRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteRentalRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateRentalRequest;
import com.etiya.rentACarSpring.core.utilities.business.BusinessRules;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.ErrorResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccessDataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccessResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.RentalDao;
import com.etiya.rentACarSpring.entities.Rental;
import com.etiya.rentACarSpring.entities.complexTypes.RentalDetail;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService) {
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<RentalSearchListDto>> getAll() {
		List<Rental> result = this.rentalDao.findAll();

		List<RentalSearchListDto> response = result.stream()
				.map(rental -> modelMapperService.forDto().map(rental, RentalSearchListDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<RentalSearchListDto>>(response);
	}

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		Result result = BusinessRules.run(checkIfCarReturned(createRentalRequest.getCarId()));

		if (result != null) {
			return result;
		}
		
		Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		this.rentalDao.save(rental);
		return new SuccessResult("Rented");
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		
		/*Rental rental = this.getUpdatedRental(updateRentalRequest).getData();

        this.rentalDao.save(rental);

        return new SuccessResult(Messages.RentalUpdated);*/
		
		RentalDetail result= this.rentalDao.getRentalDetails(updateRentalRequest.getRentalId());
	
		
		Rental rental= new Rental();
		
		rental = modelMapperService.forRequest().map(updateRentalRequest,Rental.class);

		rental.setRentDate(result.getRentDate());
		
			this.rentalDao.save(rental);
		return new SuccessResult("Updated");
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		this.rentalDao.deleteById(deleteRentalRequest.getRentalId());
		return new SuccessResult("Deleted");
	}

	private Result checkIfCarReturned(int carId) {
		//Where kullanılacak
		RentalSearchListDto result = this.rentalDao.getByCarIdWhereReturnDateIsNull(carId);
		if (result != null) {
			return new ErrorResult("Arac teslim edilmemistir");
		}
		return new SuccessResult();
	}

	/*private Result<RentalDetail> getRentalDetails(int rentalId) {
		RentalDetail result = this.rentalDao.getRentalDetails(rentalId);
	    return new SuccessResult<RentalDetail>(result);
	}
		*/
	
	
	/*@Override
    public DataResult<List<RentalDetail>> getRentalDetails() {
    List<RentalDetail> result = this.rentalDao.getRentalDetails();
    return new SuccessDataResult<List<RentalDetail>>(result);
}*/
	
	
	
}
