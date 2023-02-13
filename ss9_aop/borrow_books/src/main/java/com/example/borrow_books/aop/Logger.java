package com.example.borrow_books.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    int count = 0;

    // ghi log tất cả các hành động khiến trạng thái sách của thư viện bị thay đổi.
    @Pointcut("execution(* com.example.borrow_books.controller.BookOrderController.order(..))")
    public void getChangeOrder(){
    }

    @AfterReturning(value = "getChangeOrder()")
    public void printChangeOrder(){
        count++;
        System.out.println("Số lần mượn sách " + count);
    }

    //ghi log số lượng người đã ghé thăm thư viện sách (tất cả các thao tác)
    @Pointcut("execution(* com.example.borrow_books.controller.BookOrderController.home(..))")
    public void getChange(){
    }

    @After(value = "getChange()")
    public void printChange(){
        count++;
        System.out.println("Số lần ghé thăm tới trang mượn sách: " + count);
    }
}
