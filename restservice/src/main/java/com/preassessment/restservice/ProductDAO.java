package com.preassessment.restservice;

import com.preassessment.restservice.ProductList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductDAO {
    private static ProductList productList = new ProductList();

    // This static block is executed before executing the main block
    static {
        // Creating a few Product and adding them to the list
        productList.getProductList()
                .add(
                        new Product(
                        "Prod1",
                        "Shirt",
                        "EACH","" ));
        productList.getProductList()
                .add(
                        new Product(
                        "Prod2",
                        "Trousers",
                        "EACH","" ));
        productList.getProductList()
                .add(
                        new Product(
                        "Prod3",
                        "Tie",
                        "EACH","" ));
    }
    // Method to return the list
    public ProductList getAllProducts()
    {
        return productList;
    }

    // Method to add an employee
    // to the employees list
    public void addProduct(Product product)
    {
        productList.getProductList().add(product);
    }

    public Product checkProductCreate(Product reqProduct)
    {
        List<Product> productList1 = productList.getProductList()
                .stream()
                .filter(Product::checkProductExists)
                .collect(Collectors.toList());

        ProductList list1 = new ProductList();
        for(Product eachEmp : productList1){
            list1.getProductList().add(eachEmp);
        }

        return reqProduct;
    }

    public ProductList  sortProductList(ProductList reqProductList)
    {
        List<Product> productList1 = productList.getProductList()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        ProductList sortedProductList = new ProductList();
        for(Product eachEmp : productList1){
            sortedProductList.getProductList().add(eachEmp);
        }

        return sortedProductList;
    }
}

