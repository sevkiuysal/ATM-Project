package com.koylumuhendis.atmproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koylumuhendis.atmproject.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
