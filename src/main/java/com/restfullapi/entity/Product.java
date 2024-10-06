package com.restfullapi.entity;


import java.util.List;

import com.restfullapi.configuration.GenrateCustomeProductID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "Products")
public class Product {
	
	@Id
	@GenrateCustomeProductID
	private String product_id ;
	private String name ;
	private String discription ;
	private double product_price ;
	private long stocks ;
	
	@ManyToMany(mappedBy = "productList")
	private List<Orders> orderlistList ;
}
