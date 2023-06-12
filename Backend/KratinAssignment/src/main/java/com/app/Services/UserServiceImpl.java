package com.app.Services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.Repository.UserRepository;
import com.app.dto.Diet_dto;
import com.app.dto.Userdto;
import com.app.pojos.Diet_chart;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userrepo;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public User AddUser(Userdto user) {
		
//		String encPwd= passwordEncoder.encode(user.getPassword());
//		user.setPassword(encPwd);
		User us=mapper.map(user, User.class);
		us.cal_age();
		return userrepo.save(us);
	}
	
	@Override
	public Optional<User> showUser(Long id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id);
	}
	

	@Override
	public Optional<User> findUser( String email,String password) {
		
		
		return userrepo.findByEmailAndPassword(email,password);
		
	}

	@Override
	public boolean addDiet(String email, Diet_dto DChart) {
		Optional<User> ous=userrepo.findByEmail(email);
		if(ous.isPresent()) {
			User user=ous.get();
			Diet_chart dc=user.getDiet();
			if(dc!=null) {
				dc.setMeals(DChart.getDiet());
			}
			else {
				Diet_chart ndc=new Diet_chart();
				ndc.setMeals(DChart.getDiet());
				ndc.setUserDetail(user);
				user.setDiet(ndc);
			}
			userrepo.save(user);
			return true;
		}
		return false;
	}


	

	
	

}
