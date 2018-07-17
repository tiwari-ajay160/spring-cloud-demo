package com.dh.empregister.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dh.empregister.Service.EmpLoginDetailService;
import com.dh.empregister.mongo.User;

@RestController
@RequestMapping(value="/login")
public class EmpLoginDetailsController {

	@Autowired
	private EmpLoginDetailService loginDetailsService;
	
	@RequestMapping(value="/saveLogin",method=RequestMethod.POST)
	public User saveLoginDetails(@RequestBody User user){
		return loginDetailsService.saveUserDetails(user);
	}
	
	
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
	public List<User> getAllUsers(){
		return loginDetailsService.getAllUserDetails();
	}
	
	@RequestMapping(value="/getUser/{empId}",method=RequestMethod.GET,produces="application/json")
	public User getAllUsers(@PathVariable(value="empId") Integer empId){
		return loginDetailsService.getUserByEmpId(empId);
	}
	
	
}
