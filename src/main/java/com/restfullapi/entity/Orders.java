package com.restfullapi.entity;


import java.util.List;

import com.restfullapi.configuration.GenrateCustomeOrderID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "orders")
public class Orders {
	
	@Id
	@GenrateCustomeOrderID
	private String order_id ;
	private double quantities ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Users user ;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "order_product", 
        joinColumns = @JoinColumn(name = "order_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
	private List<Product> productList ;
}
