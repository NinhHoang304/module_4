package com.example.borrow_books.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "bookOrder")
    private Set<OrderDetail> orderDetailSet;

    public BookOrder() {
    }

    public BookOrder(int id, String name, int quantity, Set<OrderDetail> orderDetailSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.orderDetailSet = orderDetailSet;
    }

    public BookOrder(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }
}
