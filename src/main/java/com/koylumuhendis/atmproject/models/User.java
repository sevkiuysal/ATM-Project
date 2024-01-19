package com.koylumuhendis.atmproject.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="_user")
public class User extends BaseEntity{
	
	@CreationTimestamp                //==> LocalDateTime createTime=LocalDateTime.now()
	private LocalDateTime createTime;  
	
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	private Double credit;
	
	private Long userIban;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin;

	public User() {
	}

	
}
