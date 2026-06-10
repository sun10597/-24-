package org.example.iocexam.cook.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class OrderLogger {
    public void log(){
        System.out.println("주문 시작!");
    }
}
