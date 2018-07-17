package com.dh.empregister.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dh.empregister.mongo.User;
import com.dh.empregister.mongo.UserRepository;

@Service
public class EmpLoginDetailService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private EmpRegisterService registerService;
	
	public List<User> getAllUserDetails(){
		return userRepo.findAll();
	}
	
	public User getUserByEmpId(Integer empId){
		return userRepo.findByEmpId(empId);
	}
	
	public User saveUserDetails(User user) {
		if(registerService.getEmpById(user.getEmpId())==null){
			return null;
		}
		else{
			User userDomain=userRepo.findByEmpId(user.getEmpId());
			if(userDomain==null){
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				return userRepo.save(user);
			}
			else{
				userDomain.setPassword(passwordEncoder.encode(user.getPassword()));
				userDomain.setRole(user.getRole());
				return userRepo.save(userDomain);
			}
			
		}
	}

}
