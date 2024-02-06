package com.koylumuhendis.atmproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="_admin")
public class Admin extends BaseEntity {
//	
//	@OneToMany(mappedBy = "id")
//	private List<User> users;
//
//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
	public Admin() {
		
	}
	
	public static class builder{
		
		private Long id;

		private String username;
		
		private String password;
		
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
		public Admin build() {
			return new Admin(this);
		}
	}
	
	public Admin(builder builder) {
		this.id=builder.id;
		this.username=builder.username;
		this.password=builder.password;
	}
	
}
