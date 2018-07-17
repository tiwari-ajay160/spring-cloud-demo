package com.dh.empregister.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dh.empregister.mongo.CounterClass;
import com.dh.empregister.mongo.CounterClassRepo;
import com.dh.empregister.mongo.UserData;
import com.dh.empregister.mongo.UserDataRepo;

@Service
@RefreshScope
public class EmpRegisterService {
	
	
//	@Value("${defaultCount}")
	private Integer defaultCount;
	
	@Autowired
	private UserDataRepo userDataRepo;
	
	@Autowired
	private CounterClassRepo counterRepo;
	
	public String saveNewUserService(UserData user){
		
		user.setEmpId(getNextSequence(user.getClass().getSimpleName()));
		return userDataRepo.save(user).toString();
		
	}
	
	public List<UserData> getAllUsers(){
		return userDataRepo.findAll();
	}
	

	private Integer getNextSequence(String className){
		CounterClass counter=new CounterClass();
		counter.setSequence(className);
		
		List<CounterClass> counterList=counterRepo.findAll(Example.of(counter));
		if(counterList.isEmpty()){
			counter.setCount(defaultCount);
			counter.increment();
			counterRepo.save(counter);
		}else{
			counter=counterList.get(0);
			counter.increment();
			counterRepo.save(counter);
		}
		return counter.getCount();
			
	}
	
	public UserData getEmpById(Integer empId){
		return userDataRepo.findByEmpId(empId);
	}
	
}
