package com.restfullapi.dto;

import java.util.List;

import com.restfullapi.entity.Orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String user_id ;
	private String userName ;
	private String password ;
	private String email ;
}
