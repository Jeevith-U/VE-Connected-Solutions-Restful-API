package com.restfullapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfullapi.dto.ProductDto;
import com.restfullapi.entity.Product;
import com.restfullapi.responseStructure.ResponseStructure;
import com.restfullapi.service.ProductService;


@RestController
public class ProductController {
	
	private ProductService productService ;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService ;
	}
	
	@PostMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product ){
		return productService.saveProduct(product) ;
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<ProductDto>> findProduct(@PathVariable String id){
		
		return productService.findProduct(id) ;
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product, @PathVariable String id){
		
		return productService.updateProduct(product, id) ;
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> deleteProduct(@RequestBody Product product, @PathVariable String id){
		
		return productService.deleteProduct(product, id) ;
	}
	
	@GetMapping("/product")
	public ResponseEntity<ResponseStructure<List<ProductDto>>> findAllProducts(){
		
		return productService.findAllProduct() ;
	}
}
