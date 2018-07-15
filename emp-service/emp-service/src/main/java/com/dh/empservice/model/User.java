package com.dh.empservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {
	
	

	@Id
	private String id;
	
	private Integer empId;
	
	private Double workingHours;
	
	private Date workingDate;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(Double workingHours) {
		this.workingHours = workingHours;
	}

	public Date getWorkingDate() {
		return workingDate;
	}

	public void setWorkingDate(Date workingDate) {
		this.workingDate = workingDate;
	}
	

	@Override
	public String toString() {
		return "empId: "+this.empId+" hours;"+this.workingHours+" date:"+this.workingDate.toString();
	}

}
