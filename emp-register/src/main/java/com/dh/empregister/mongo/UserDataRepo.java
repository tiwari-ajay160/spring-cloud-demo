package com.dh.empregister.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepo extends MongoRepository<UserData, String>{
	
	public UserData findByEmpId(Integer empId);

}
