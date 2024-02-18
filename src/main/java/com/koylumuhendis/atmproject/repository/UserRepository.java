package com.koylumuhendis.atmproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.koylumuhendis.atmproject.dto.UserDto;
import com.koylumuhendis.atmproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


	@Modifying
	@Transactional
	@Query(value ="update User u\r\n"
			+ "	set u.balance=:money\r\n"
			+ "	where u.id=:id")
	public void updateBalanceById(@Param("id")Long id,@Param("money") Double money);
		
	public Optional<User> findById(Long id);
	
	public Optional<User> findByUserIban(Long userIban);

	public User findUserByUsername(String name);
	

	

}
