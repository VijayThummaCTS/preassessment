package com.preassessment.restservice;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<Product> productList;

    // Method to return the list of product
    public List<Product> getProductList()
    {
        if (productList == null) {
            productList = new ArrayList<>();
        }
        return productList;
    }

    public void setProductList(List<Product> productList)
    {
        this.productList = productList;
    }
}
