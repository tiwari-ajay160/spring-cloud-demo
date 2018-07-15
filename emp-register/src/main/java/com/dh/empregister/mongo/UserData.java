package com.dh.empregister.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserData {
	
	@Id
	private String id;
	
	private Integer empId;
	
	private String empName;
	
	private Integer empPhone;
	
	private String empGender;
	
	private Integer empAge;
	
	private String empCity;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(Integer empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	@Override
	public String toString() {
		
		return "id:"+this.empId+" name:"+this.empName+" gender:"+this.empGender;
	}
	
	

}
