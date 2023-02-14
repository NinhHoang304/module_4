package com.example.cart.dto;

import com.example.cart.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    //Phương thức checkIntemInCart() để kiểm tra xem sản phẩm đó đã có trong giỏ hàng hay chưa
    private boolean checkItemCart(ProductDto productDto){
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()){
            if (entry.getKey().getId() == productDto.getId()){
                return true;
            }
        }
        return false;
    }
    //Phương thức addProduct() được sử dụng để thêm sản phẩm vào trong giỏ hàng.
    private Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto productDto){
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()){
            if (entry.getKey().getId() == productDto.getId()){
                return entry;
            }
        }
        return null;
    }
    public void addProduct(ProductDto productDto){
        if (productMap.containsKey(productDto)){
            // update value + 1, use auto boxing
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue);
        }else {
            // nếu nó chưa tồn tại sẽ thêm mới vào
            productMap.put(productDto, 1);
        }
    }
    //Phương thức countProductQuantity() dùng để đếm số lượng sản phẩm đó hiện có trong giỏ hàng.
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()){
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }
    //Phương thức countItemQuantity() để đếm số lượng sản phẩm có trong giỏ hàng.
    public Integer countItemQuantity(){
        return productMap.size();
    }
    //Phương thức countTotalPayment() dùng để tính tổng số tiền cần phải thanh toán.
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()){
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
