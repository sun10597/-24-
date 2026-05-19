package org.example.iocexam.cook.service;

import org.example.iocexam.cook.DAO.Cook;
import org.example.iocexam.cook.DAO.OrderLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private Cook cook;
    @Autowired
    private OrderLogger orderLogger;

    public OrderService(Cook cook, OrderLogger orderLogger){
        this.cook = cook;
        this.orderLogger = orderLogger;
    }
    public void order(){
        orderLogger.log();
        cook.cook();
    }

}
