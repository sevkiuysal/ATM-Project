package com.koylumuhendis.atmproject.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

public class UserDto {
	
	private Long id;

    private String username;
    
	private LocalDateTime createTime;  
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	private Double balance;
	
	private Long userIban;

	public UserDto() {
	}

	
	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
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


	public static class builder{
		
		private Long id;
		
		private String username;
	    
		private LocalDateTime createTime;  

		private LocalDateTime updateTime;
		
		private Double balance;
		
		private Long userIban;
		
		public builder id(Long id) {
			this.id=id;
			return this;
		}
		public builder username(String username) {
			this.username=username;
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
		public UserDto build() {
			return new UserDto(this);
		}
	}
	
	public UserDto(builder builder) {
		this.id=builder.id;
		this.username=builder.username;
		this.createTime=builder.createTime;
		this.updateTime=builder.updateTime;
		this.balance=builder.balance;
		this.userIban=builder.userIban;
	}
}
