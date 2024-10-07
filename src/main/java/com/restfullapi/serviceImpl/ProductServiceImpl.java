package com.restfullapi.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfullapi.dao.ProductDao;
import com.restfullapi.dto.ProductDto;
import com.restfullapi.entity.Product;
import com.restfullapi.exception.OrderNotFoundException;
import com.restfullapi.responseStructure.ResponseStructure;
import com.restfullapi.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
    
    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * Saves a new product in the database.
     *
     * @param product the product to save
     * @return a response entity containing the saved product
     */
    @Override
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
    @Override
    public ResponseEntity<ResponseStructure<ProductDto>> findProduct(String id) {
        Product product = productDao.findProduct(id).orElseThrow(() -> new OrderNotFoundException());
        
        ResponseStructure<ProductDto> response = new ResponseStructure<ProductDto>(HttpStatus.FOUND.value(),
                "Product found successfully.", new ProductDto(product.getProduct_id(), product.getName(), product.getDescription(), product.getProduct_price(), product.getStocks()));
        return new ResponseEntity<ResponseStructure<ProductDto>>(response, HttpStatus.FOUND);
    }

    /**
     * Updates an existing product.
     *
     * @param product the updated product details
     * @param id the ID of the product to update
     * @return a response entity with the updated product
     */
    @Override
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
    @Override
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
    @Override
    public ResponseEntity<ResponseStructure<List<ProductDto>>> findAllProduct() {
       
    	List<Product> products = productDao.findAllProducts();
        
        List<ProductDto> dtoProducts = new ArrayList<>() ;
        
        for(Product product: products) {
        	
        	ProductDto proddto = new ProductDto() ;
        	
        	proddto.setProduct_id(product.getProduct_id());
        	proddto.setName(product.getName());
        	proddto.setDescription(product.getDescription());
        	proddto.setProduct_price(product.getProduct_price());
        	proddto.setStocks(product.getStocks()) ;
        }
        
        ResponseStructure<List<ProductDto>> response = new ResponseStructure<List<ProductDto>>(HttpStatus.FOUND.value(),
                "Products found successfully.", dtoProducts);
        return new ResponseEntity<ResponseStructure<List<ProductDto>>>(response, HttpStatus.FOUND);
    }
}
