package com.app.Services;

import java.util.Optional;

import com.app.dto.Diet_dto;
import com.app.dto.Userdto;
import com.app.pojos.Diet_chart;
import com.app.pojos.User;

public interface UserService {
	
	User AddUser(Userdto user);
	Optional<User> findUser( String email,String password);
	boolean addDiet(String email,Diet_dto DChart);
	
	Optional<User> showUser(Long id);
	

}
