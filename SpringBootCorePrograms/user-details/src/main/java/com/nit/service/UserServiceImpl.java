package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.User;
import com.nit.repository.IUserRepo;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepo userRepo;
	
	@Override
	public String registerUser(User user) {
		return "User registed with ID: "+userRepo.save(user).getUserId() ;
	}
	
	
	

	
}
