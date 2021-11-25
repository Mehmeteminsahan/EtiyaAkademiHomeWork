package com.etiya.rentACarSpring.business.abstracts;

import java.util.List;

import com.etiya.rentACarSpring.business.dtos.UserSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateUserRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteUserRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateUserRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

public interface UserService {
	
	DataResult<List<UserSearchListDto>> getAll();
	Result add(CreateUserRequest createUserRequest);
	Result update(UpdateUserRequest updateUserRequest);
	Result delete(DeleteUserRequest deleteUserRequest);
}
