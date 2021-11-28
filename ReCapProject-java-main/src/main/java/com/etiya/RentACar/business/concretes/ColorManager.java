package com.etiya.RentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACar.business.abstracts.ColorService;
import com.etiya.RentACar.business.requests.color.CreateColorRequest;
import com.etiya.RentACar.business.requests.color.DeleteColorRequest;
import com.etiya.RentACar.business.requests.color.UpdateColorRequest;
import com.etiya.RentACar.core.utilities.Message.Messages;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.core.utilities.results.Result;
import com.etiya.RentACar.core.utilities.results.SuccessDataResult;
import com.etiya.RentACar.core.utilities.results.SuccessResult;
import com.etiya.RentACar.dataAccess.abstracts.ColorDao;
import com.etiya.RentACar.entites.Color;

@Service
public class ColorManager implements ColorService{

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	private ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		super();
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<Color>> getAll() {
		
		return new SuccessDataResult<List<Color>>(this.colorDao.findAll(),Messages.ColorListed);
	}

	@Override
	public Result add(CreateColorRequest createColorRequest) {
		Color color=this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		Color color=this.modelMapperService.forRequest().map(updateColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		Color color=this.modelMapperService.forRequest().map(deleteColorRequest, Color.class);
		this.colorDao.delete(color);
		return new SuccessResult();
	}

}
