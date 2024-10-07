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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Endpoint to save a new product.
     * @param product - Product object that will be created.
     * @return ResponseEntity containing the ResponseStructure with the created product and HttpStatus.
     */
    @Operation(description = "To save the product to the database")
    @ApiResponses(value = @ApiResponse(description = "Product saved successfully", responseCode = "201"))
    @PostMapping("/product")
    public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    /**
     * Endpoint to find a product by ID.
     * @param id - The ID of the product to be retrieved.
     * @return ResponseEntity containing the ResponseStructure with the found product or an error if not found.
     */
    @Operation(description = "Retrieve a product by its ID")
    @ApiResponses(value = {
        @ApiResponse(description = "Product found successfully", responseCode = "200"),
        @ApiResponse(description = "Product not found", responseCode = "404")
    })
    @GetMapping("/product/{id}")
    public ResponseEntity<ResponseStructure<ProductDto>> findProduct(@PathVariable String id) {
        return productService.findProduct(id);
    }

    /**
     * Endpoint to update an existing product by ID.
     * @param product - Updated Product object with new details.
     * @param id - The ID of the product to be updated.
     * @return ResponseEntity containing the ResponseStructure with the updated product and HttpStatus.
     */
    @Operation(description = "Update an existing product by ID")
    @ApiResponses(value = @ApiResponse(description = "Product updated successfully", responseCode = "200"))
    @PutMapping("/product/{id}")
    public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product, @PathVariable String id) {
        return productService.updateProduct(product, id);
    }

    /**
     * Endpoint to delete a product by ID.
     * @param product - Product object to be deleted (Optional, could only use ID).
     * @param id - The ID of the product to be deleted.
     * @return ResponseEntity containing the ResponseStructure indicating whether the deletion was successful.
     */
    @Operation(description = "Delete a product by ID")
    @ApiResponses(value = @ApiResponse(description = "Product deleted successfully", responseCode = "200"))
    @DeleteMapping("/product/{id}")
    public ResponseEntity<ResponseStructure<Boolean>> deleteProduct(@RequestBody Product product, @PathVariable String id) {
        return productService.deleteProduct(product, id);
    }

    /**
     * Endpoint to retrieve all products.
     * @return ResponseEntity containing the ResponseStructure with the list of all products.
     */
    @Operation(description = "Retrieve all products")
    @ApiResponses(value = @ApiResponse(description = "Products retrieved successfully", responseCode = "200"))
    @GetMapping("/product")
    public ResponseEntity<ResponseStructure<List<ProductDto>>> findAllProducts() {
        return productService.findAllProduct();
    }

}
