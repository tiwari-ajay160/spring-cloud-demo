package com.dh.empservice.mongo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dh.empservice.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	public User findByEmpIdAndWorkingDate(Integer empId,Date date);
	
	public List<User> findByEmpId(Integer empId);

}
