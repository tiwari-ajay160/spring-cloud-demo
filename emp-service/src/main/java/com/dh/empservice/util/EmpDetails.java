package com.dh.empservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dh.empservice.model.User;

@Service
public class EmpDetails {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public boolean validateEmpId(Integer empId){
		ResponseEntity<Boolean> response=restTemplate.getForEntity("http://localhost:9999/emp-register/validate/"+empId, Boolean.class);
		return response.getBody();
	}

}
