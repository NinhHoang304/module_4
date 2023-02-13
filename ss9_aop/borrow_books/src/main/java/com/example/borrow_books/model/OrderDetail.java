package com.example.borrow_books.model;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libCard;

    @ManyToOne
    @JoinColumn(name = "book_order_id", referencedColumnName = "id")
    private BookOrder bookOrder;

    public OrderDetail() {
    }

    public OrderDetail(int id, String libCard, BookOrder bookOrder) {
        this.id = id;
        this.libCard = libCard;
        this.bookOrder = bookOrder;
    }

    public OrderDetail(String libCard, BookOrder bookOrder) {
        this.libCard = libCard;
        this.bookOrder = bookOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibCard() {
        return libCard;
    }

    public void setLibCard(String libCard) {
        this.libCard = libCard;
    }

    public BookOrder getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }
}
