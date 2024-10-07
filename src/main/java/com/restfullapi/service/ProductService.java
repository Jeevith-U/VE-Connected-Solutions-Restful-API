package com.restfullapi.service;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfullapi.dao.ProductDao;
import com.restfullapi.entity.Product;
import com.restfullapi.exception.OrderNotFoundException;
import com.restfullapi.responseStructure.ResponseStructure;


@Service
public class ProductService {
    
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * Saves a new product in the database.
     *
     * @param product the product to save
     * @return a response entity containing the saved product
     */
    public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
        product = productDao.saveProduct(product);
        ResponseStructure<Product> response = new ResponseStructure<Product>(HttpStatus.CREATED.value(),
                "Product saved successfully.", product);
        return new ResponseEntity<ResponseStructure<Product>>(response, HttpStatus.CREATED);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to find
     * @return a response entity containing the found product
     */
    public ResponseEntity<ResponseStructure<Product>> findProduct(String id) {
        Product product = productDao.findProduct(id).orElseThrow(() -> new OrderNotFoundException());
        ResponseStructure<Product> response = new ResponseStructure<Product>(HttpStatus.FOUND.value(),
                "Product found successfully.", product);
        return new ResponseEntity<ResponseStructure<Product>>(response, HttpStatus.FOUND);
    }

    /**
     * Updates an existing product.
     *
     * @param product the updated product details
     * @param id the ID of the product to update
     * @return a response entity with the updated product
     */
    public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, String id) {
        Product upProduct = productDao.findProduct(id).orElseThrow(() -> new OrderNotFoundException());
        productDao.saveProduct(product);
        ResponseStructure<Product> response = new ResponseStructure<Product>(HttpStatus.OK.value(),
                "Updated successfully.", product);
        return new ResponseEntity<ResponseStructure<Product>>(response, HttpStatus.OK);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param product the product to delete
     * @param id the ID of the product to delete
     * @return a response entity indicating the deletion status
     */
    public ResponseEntity<ResponseStructure<Boolean>> deleteProduct(Product product, String id) {
        product = productDao.findProduct(id).orElseThrow(() -> new OrderNotFoundException());
        productDao.deleteProduct(product);
        ResponseStructure<Boolean> response = new ResponseStructure<Boolean>(HttpStatus.OK.value(),
                "Deleted successfully.", true);
        return new ResponseEntity<ResponseStructure<Boolean>>(response, HttpStatus.OK);
    }

    /**
     * Retrieves a list of all products.
     *
     * @return a response entity containing a list of products
     */
    public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
        List<Product> products = productDao.findAllProducts();
        ResponseStructure<List<Product>> response = new ResponseStructure<List<Product>>(HttpStatus.FOUND.value(),
                "Products found successfully.", products);
        return new ResponseEntity<ResponseStructure<List<Product>>>(response, HttpStatus.FOUND);
    }
}
