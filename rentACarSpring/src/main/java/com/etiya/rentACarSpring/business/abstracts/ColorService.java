package com.etiya.rentACarSpring.business.abstracts;

import com.etiya.rentACarSpring.business.requests.creates.CreateColorRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteColorRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateColorRequest;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface ColorService {
	Result add(CreateColorRequest createColorRequest);
	Result update(UpdateColorRequest updateColorRequest);
	Result delete(DeleteColorRequest deleteColorRequest);
}
