package com.koylumuhendis.atmproject.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="_user")
public class User extends BaseEntity{
	
	@CreationTimestamp                //==> private LocalDateTime createTime=LocalDateTime.now()
	private LocalDateTime createTime;  
	
	@UpdateTimestamp
	
	private LocalDateTime updateTime;
	
	@NotNull
	private Double balance;
	
	private Long userIban;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin;

	public User() {
	}
	

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public Double getBalance() {
		return balance;
	}

	public Long getUserIban() {
		return userIban;
	}

	public Admin getAdmin() {
		return admin;
	}

public static class builder{
		
		private Long id;
		
		private String username;
		
		private String password;
	    
		private LocalDateTime createTime;  

		private LocalDateTime updateTime;
		
		private Double balance;
		
		private Long userIban;
		
		private Admin admin;
		
		public builder id(Long id) {
			this.id=id;
			return this;
		}
		public builder username(String username) {
			this.username=username;
			return this;
		}
		public builder password(String password) {
			this.password=password;
			return this;
		}
		public builder createTime(LocalDateTime createTime) {
			this.createTime=createTime;
			return this;
		}
		public builder updateTime(LocalDateTime updateTime) {
			this.updateTime=updateTime;
			return this;
		}
		public builder balance(Double balance) {
			this.balance=balance;
			return this;
		}
		public builder userIban(Long userIban) {
			this.userIban=userIban;
			return this;
		}
		public builder admin(Admin admin) {
			this.admin=admin;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	public User(builder builder) {
		this.id=builder.id;
		this.username=builder.username;
		this.password=builder.password;
		this.createTime=builder.createTime;
		this.updateTime=builder.updateTime;
		this.balance=builder.balance;
		this.userIban=builder.userIban;
		this.admin=builder.admin;
	}
	
}
