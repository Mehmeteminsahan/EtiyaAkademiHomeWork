package bussiness.concretes;

import java.util.List;

import bussiness.abstracts.ColorService;
import core.utilities.result.DataResult;
import core.utilities.result.ErrorResult;
import core.utilities.result.Result;
import core.utilities.result.SuccessDataResult;
import core.utilities.result.SuccessResult;
import dataAccess.abstracts.ColorRepository;
import entities.concretes.Brand;
import entities.concretes.Color;

public class ColorManager implements ColorService{
	private ColorRepository colorRepository;

	public ColorManager(ColorRepository colorRepository) {
		super();
		this.colorRepository = colorRepository;
	}

	@Override
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(this.colorRepository.getAll());
	}

	@Override
	public Result add(Color color) {
		this.colorRepository.add(color);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result delete(int id) {
		int counter=0;
		for (Color brand : this.colorRepository.getAll()) {
			if(brand.getColorId()==id) {
				this.colorRepository.delete(counter);
				return new SuccessResult("Silindi.");
			}
		
			counter++;
			
		}
		return new ErrorResult("Böyle bir id yok");
	}

	@Override
	public Result update(int id,Color color) {
		int counter=0;
		for (Color item : this.colorRepository.getAll()) {
			if(item.getColorId()==id) {
				this.colorRepository.update(counter,color);
				return new SuccessResult("Güncellendi.");
			}
		
			counter++;
			
		}
		return new ErrorResult("Böyle bir id yok");
		
	}
	

}
