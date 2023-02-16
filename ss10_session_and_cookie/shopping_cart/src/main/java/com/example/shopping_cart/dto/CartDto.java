package com.example.shopping_cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto){
        if (productMap.containsKey(productDto)){
            //update value +1
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue +1);
        }else {
            productMap.put(productDto, 1); // them vao lan dau
        }
    }
}
