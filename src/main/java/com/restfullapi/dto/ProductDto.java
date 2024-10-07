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
public class ProductDto {
	
	private String product_id ;
	private String name ;
	private String description ;
	private double product_price ;
	private long stocks ;
}
