package com.dh.empregister.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CounterClass {
	
	@Id
	private String id;
	
	private Integer count;
	
	private String sequence;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	public Integer increment(){
		return this.count+=1;
	}

}
