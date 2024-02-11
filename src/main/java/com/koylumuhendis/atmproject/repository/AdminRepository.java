package com.koylumuhendis.atmproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koylumuhendis.atmproject.model.Admin;
import com.koylumuhendis.atmproject.model.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

	Optional<Admin> findAdminByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.adminId=:id")
	public List<User> getUsersByAdminId(@Param("id")Long id);
	
	
	

}
