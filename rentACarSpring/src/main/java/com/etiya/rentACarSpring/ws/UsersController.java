package com.etiya.rentACarSpring.ws;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.business.abstracts.UserService;
import com.etiya.rentACarSpring.business.dtos.UserSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateUserRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteUserRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateUserRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;

@RestController
@RequestMapping("api/users")
public class UsersController {
	
	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("all")
	public DataResult<List<UserSearchListDto>> getAll(){
		return this.userService.getAll();
	} 
	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateUserRequest createUserRequest) {
		return this.userService.add(createUserRequest);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateUserRequest updateUserRequest) {
		return this.userService.update(updateUserRequest);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteUserRequest deleteUserRequest) {
		return this.userService.delete(deleteUserRequest);
	}
	
	
}
