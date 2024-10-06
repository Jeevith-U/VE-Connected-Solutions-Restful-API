package com.restfullapi.entity;

import java.util.List;

import com.restfullapi.configuration.GenrateCustomeUserID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
	private String userName ;
	private String password ;
	private String email ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Orders> ordersList ;
	
}
