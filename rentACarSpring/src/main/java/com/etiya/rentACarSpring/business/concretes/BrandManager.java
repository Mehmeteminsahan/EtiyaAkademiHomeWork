package com.etiya.rentACarSpring.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.business.abstracts.BrandService;
import com.etiya.rentACarSpring.business.requests.creates.CreateBrandRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteBrandRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateBrandRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccessResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.BrandDao;
import com.etiya.rentACarSpring.entities.Brand;

@Service
public class BrandManager implements BrandService{

	private BrandDao brandDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccessResult("The brand has been added.");
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccessResult("The brand has been updated.");
	}

	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {
		//Brand brand = modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		//this.brandDao.delete(brand);
		this.brandDao.deleteById(deleteBrandRequest.getBrandId());
		return new SuccessResult("The brand has been deleted.");
	}

}
