package com.restfullapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfullapi.dto.ProductDto;
import com.restfullapi.entity.Product;
import com.restfullapi.responseStructure.ResponseStructure;

@Service
public interface ProductService {
	
	 public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) ;
	 
	 public ResponseEntity<ResponseStructure<ProductDto>> findProduct(String id) ;
	 
	 public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, String id) ;
	 
	 public ResponseEntity<ResponseStructure<Boolean>> deleteProduct(Product product, String id) ;
	 
	 public ResponseEntity<ResponseStructure<List<ProductDto>>> findAllProduct() ;
}
