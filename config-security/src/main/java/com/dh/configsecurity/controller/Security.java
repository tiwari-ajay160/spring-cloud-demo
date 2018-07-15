package com.dh.configsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Security {

	
	@RequestMapping(value="secure1",method=RequestMethod.GET)
	public String secure1(){
		return "secure1";
	}
	
	@RequestMapping(value="secure2",method=RequestMethod.GET)
	public String secure2(){
		return "secure2";
	}
}
