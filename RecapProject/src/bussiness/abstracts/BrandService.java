package bussiness.abstracts;

import java.util.List;

import core.utilities.result.DataResult;
import core.utilities.result.Result;
import entities.concretes.Brand;




public interface BrandService {
	DataResult<List<Brand>> getAll();
	Result add(Brand brand);
	Result delete(int id);
	Result update(int id,Brand brand);
}
