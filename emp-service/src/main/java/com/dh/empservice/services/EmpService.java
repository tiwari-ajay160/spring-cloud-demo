package com.dh.empservice.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dh.empservice.model.User;
import com.dh.empservice.mongo.UserRepository;
import com.dh.empservice.util.EmpDetails;

@Service
public class EmpService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmpDetails empDetailsUtil;
	
	public List<User> getAllEmpData(Integer empId){
		return userRepo.findByEmpId(empId);
	}
	
	public List<String> saveWorkingHours(List<User> userList){
		
		List<String> outPutMessage=new ArrayList<>();
		
		for(User user:userList){
		
		if(empDetailsUtil.validateEmpId(user.getEmpId())){
			
			User userDomain=userRepo.findByEmpIdAndWorkingDate(user.getEmpId(), user.getWorkingDate());
			if(userDomain==null){
				outPutMessage.add(userRepo.save(user).toString());
			}
			else{
				userDomain.setWorkingHours(user.getWorkingHours());
				outPutMessage.add(userRepo.save(userDomain).toString());
			}
		}
		else{
			outPutMessage.add("invalid empId: "+user.getEmpId());
		}
		}
		return outPutMessage;
	}
	
	public Double getWokringHoursByEmpId(Integer empId){
		return userRepo.findByEmpId(empId).stream().mapToDouble(e-> e.getWorkingHours()).average().getAsDouble();
	}
	
	public Map<Integer, Double> getAllEmpAverage(){
		return userRepo.findAll().stream().
		collect(Collectors.groupingBy(User::getEmpId, Collectors.averagingDouble(User::getWorkingHours)));
	}

	
}
