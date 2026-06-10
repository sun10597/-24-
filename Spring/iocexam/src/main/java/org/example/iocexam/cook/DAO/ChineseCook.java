package org.example.iocexam.cook.DAO;

import org.springframework.stereotype.Repository;

//@Repository
public class ChineseCook implements Cook{

    @Override
    public void cook() {
        System.out.println("짜장면을 만듭니다.");
    }
}
