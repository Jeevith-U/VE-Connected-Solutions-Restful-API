package com.restfullapi.entity;

import java.util.List;

import com.restfullapi.configuration.GenrateCustomeUserID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class Users {
	
	@Id
	@GenrateCustomeUserID
	private String user_id ;
	@NotNull(message = "username is required")
	@Size(min = 3, max = 25, message = "username should be between 5 and 20 character")
	private String userName ;
	@NotNull(message = "password is required")
	@Size(min = 8, message = "Password must be at least 8 characters")
	private String password ;
	@Email(message = "Email should be valid")
	private String email ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Orders> ordersList ;
	
}
