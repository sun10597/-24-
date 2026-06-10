package org.example.iocexam.cook;

import org.example.iocexam.cook.controller.CookConfig;
import org.example.iocexam.cook.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CookMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CookConfig.class);

        OrderService orderService = context.getBean(OrderService.class);

        orderService.order();
    }
}
