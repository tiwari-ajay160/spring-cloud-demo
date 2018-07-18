package com.dh.empregister.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping(value="/saveNewUser")
	public String saveNewUser(@RequestBody UserData userData){
		return empService.saveNewUserService(userData);
	}
	
	@GetMapping(value="/getAllUsers")
	public List<UserData> getAllUser(){
		return empService.getAllUsers();
	}
	
	@GetMapping(value="/validate/{empId}")
	public Boolean findByEmpid(@PathVariable(value="empId")Integer empId){
		return empService.getEmpById(empId)==null ? false : true;
	}
	
	
	
}
