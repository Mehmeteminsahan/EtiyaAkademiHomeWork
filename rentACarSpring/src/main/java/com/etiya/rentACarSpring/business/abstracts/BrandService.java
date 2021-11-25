package com.etiya.rentACarSpring.business.abstracts;

import com.etiya.rentACarSpring.business.requests.creates.CreateBrandRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteBrandRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateBrandRequest;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface BrandService {
	Result add(CreateBrandRequest createBrandRequest);
	Result update(UpdateBrandRequest updateBrandRequest);
	Result delete(DeleteBrandRequest deleteBrandRequest);
}
