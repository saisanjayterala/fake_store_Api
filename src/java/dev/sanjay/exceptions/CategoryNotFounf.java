package dev.sanjay.productservice.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    private String category_Id;

    public ProductNotFoundException(String categories_Id) {
        this.categories_Id = categories_Id;
    }

    public String getCategoryId() {
        return categories_Id;
    }
}