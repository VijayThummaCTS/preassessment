package com.preassessment.restservice;

public class Product {
    public Product() {}

    // Parameterized Constructor to assign the values to the properties of the entity
    public Product(String productId, String productName, String unitOfMeasure,String Status)
    {
        super();
        this.productId = productId;
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
        this.Status = Status;
    }

    private String productId;
    private String productName;
    private String unitOfMeasure;
    private String Status;

    // Overriding the toString method to find all the values
    @Override
    public String toString()
    {
        return "Product [productId="
                + productId + ", productName="
                + productName + ", unitOfMeasure="
                + unitOfMeasure + ", Status="
                + Status +"]";
    }

    // Getters and setters of the properties
    public String getProductId()
    {
        return productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getUnitOfMeasure()
    {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String lastName)
    {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getStatus()
    {
        return Status;
    }

    public void setStatus(String Status)
    {
        this.Status = Status;
    }

    public boolean checkProductExists() {

        boolean returnStatus = false;
        if(this.productId.equalsIgnoreCase(this.getProductId())){
            returnStatus=true;
        }
        return returnStatus;
    }

    public Product doesProductExists(Product product) {

        if(this.productId.equalsIgnoreCase(product.getProductId())){
            product.setStatus("Exists");
        }
        else{
            product.setStatus("Created");
        }
        return product;
    }

}
