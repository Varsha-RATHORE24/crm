package com.example.CRMProject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	 User findByNameAndPassword(String username,String password);


}
