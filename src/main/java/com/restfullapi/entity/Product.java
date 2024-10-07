package com.restfullapi.entity;


import java.util.List;

import com.restfullapi.configuration.GenrateCustomeProductID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
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
@Table(name = "Products")
public class Product {
	
	@Id
	@GenrateCustomeProductID
    private String product_id;

    @NotNull(message = "Name should not be null")
    @Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters")
    private String name;

    @NotNull(message = "Description should not be null")
    @Size(min = 10, message = "Description must be at least 10 characters long")
    private String description;

    @NotNull(message = "Product price should not be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Product price must be greater than 0")
    private double product_price;

    @NotNull(message = "Stocks should not be null")
    @Min(value = 0, message = "Stocks must be a non-negative number")
    private long stocks;

    @ManyToMany(mappedBy = "productList")
    private List<Orders> orderlistList;}
