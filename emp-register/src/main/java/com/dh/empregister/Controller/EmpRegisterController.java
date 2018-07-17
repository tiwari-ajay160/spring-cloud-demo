package com.dh.empregister.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dh.empregister.Service.EmpRegisterService;
import com.dh.empregister.mongo.User;
import com.dh.empregister.mongo.UserData;

@RestController
@RequestMapping(value="/register")
public class EmpRegisterController {
	
	@Autowired
	private EmpRegisterService empService;

	@RequestMapping(value="/saveNewUser",method=RequestMethod.POST)
	public String saveNewUser(@RequestBody UserData userData){
		return empService.saveNewUserService(userData);
	}
	
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
	public List<UserData> getAllUser(){
		return empService.getAllUsers();
	}
	
	@RequestMapping(value="/validate/{empId}",method=RequestMethod.GET)
	public Boolean findByEmpid(@PathVariable(value="empId")Integer empId){
		return empService.getEmpById(empId)==null ? false : true;
	}
	
	
	
}
