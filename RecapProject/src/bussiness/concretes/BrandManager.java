package bussiness.concretes;

import java.util.List;

import bussiness.abstracts.BrandService;
import core.utilities.result.DataResult;
import core.utilities.result.ErrorResult;
import core.utilities.result.Result;
import core.utilities.result.SuccessDataResult;
import core.utilities.result.SuccessResult;
import dataAccess.abstracts.BrandRepository;
import entities.concretes.Brand;
import entities.concretes.Car;


public class BrandManager implements BrandService {
	private BrandRepository brandRepository;

	public BrandManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		return new SuccessDataResult<List<Brand>>(this.brandRepository.getAll());
	}

	@Override
	public Result add(Brand brand) {
		this.brandRepository.add(brand);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result delete(int id) {
		int counter=0;
		for (Brand brand : this.brandRepository.getAll()) {
			if(brand.getBrandId()==id) {
				this.brandRepository.delete(counter);
				return new SuccessResult("Silindi.");
			}
		
			counter++;
			
		}
		return new ErrorResult("Böyle bir id yok");
	}

	@Override
	public Result update(int id,Brand brand) {
		int counter=0;
		for (Brand item : this.brandRepository.getAll()) {
			if(item.getBrandId()==id) {
				this.brandRepository.update(counter,brand);
				return new SuccessResult("Güncellendi.");
			}
		
			counter++;
			
		}
		return new ErrorResult("Böyle bir id yok");
		
	}
	}
	
	
