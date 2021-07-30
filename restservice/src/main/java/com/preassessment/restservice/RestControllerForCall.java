package com.preassessment.restservice;

import java.net.URI;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Import the above-defined classes to use the properties of those classes
import com.preassessment.restservice.ProductList;
import com.preassessment.restservice.ProductDAO;
import com.preassessment.restservice.Product;

// Creating the REST controller
@RestController
public class RestControllerForCall {

    private static final Logger logger = Logger.getLogger(RestControllerForCall.class.getName());

    @Autowired
    private ProductDAO ProductDao;

    // Implementing a GET method to get the list of all the Products
    @GetMapping(
            path = "/list",
            produces = "application/json")

    public ProductList getProducts(){
        logger.info("List of All Products");
        return ProductDao.getAllProducts();
    }

    // Create a POST method to check a Product
    @PostMapping(
            path = "/createProduct",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> checkProduct(
            @RequestBody Product reqProduct)
    {
        Product resProduct = ProductDao.checkProductCreate(reqProduct);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand()
                .toUri();

        return ResponseEntity
                .created(location)
                .body(resProduct);
    }

    // Create a POST method to check a Product
    @PostMapping(
            path = "/sortProducts",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> sortProducts(
            @RequestBody ProductList productList)
    {

        ProductList sortedResProductList = ProductDao.sortProductList(productList);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand()
                .toUri();

        return ResponseEntity
                .created(location)
                .body(sortedResProductList);
    }
}

