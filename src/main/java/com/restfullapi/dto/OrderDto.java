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
public class OrderDto {
	
	private String order_id ;
	private double quantities ;

}
