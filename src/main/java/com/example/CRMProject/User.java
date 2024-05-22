package com.example.CRMProject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	    
	    @NotBlank(message = "password is manderory")
	    private String password;
	    
	    @NotBlank(message = "Name is mandatory")
	    private String name;
	    
	    @NotBlank(message = "Email is mandatory")
	    private String email;
	    
	    @NotBlank(message = "role is mandatory")
	    private String role;
	    
	    @NotNull(message= "whatever")
	    private long mobNo;

		public User(long id, @NotBlank(message = "password is manderory") String password,
				@NotBlank(message = "Name is mandatory") String name,
				@NotBlank(message = "Email is mandatory") String email,
				@NotBlank(message = "role is mandatory") String role, @NotNull(message = "whatever") long mobNo) {
			super();
			this.id = id;
			this.password = password;
			this.name = name;
			this.email = email;
			this.role = role;
			this.mobNo = mobNo;
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public long getMobNo() {
			return mobNo;
		}

		public void setMobNo(long mobNo) {
			this.mobNo = mobNo;
		}

	    



}
