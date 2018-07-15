package com.dh.empservice.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dh.empservice.model.User;
import com.dh.empservice.services.EmpService;

@RestController
public class Employee {
	
	@Autowired
	private EmpService employeeService;


	@RequestMapping(value="/saveHours",method=RequestMethod.POST)
	public List<String> saveWorkingHours(@RequestBody List<User> user){
		return employeeService.saveWorkingHours(user);
	}
	
	@RequestMapping(value="/empWorkingData/{empId}",method=RequestMethod.GET)
	public List<User> getAllWorkingData(@PathVariable(value="empId") Integer empId){
		return employeeService.getAllEmpData(empId);
	}
	
	@RequestMapping(value="/getEmpHours",method=RequestMethod.GET)
	public String getWorkingHours(@RequestParam(value="eid") Integer eid){
		return "testing security getEmpHours";
//		return employeeService.getWokringHoursByEmpId(eid);
	}
	
	@RequestMapping(value="/allEmpAvg",method=RequestMethod.GET)
	public Map<Integer, Double> getAllEmpAvg(){
		return employeeService.getAllEmpAverage();
	}
	
}
