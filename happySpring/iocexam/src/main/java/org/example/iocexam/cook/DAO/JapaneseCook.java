package org.example.iocexam.cook.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class JapaneseCook implements Cook{
    @Override
    public void cook() {
        System.out.println("초밥을 만듭니다");
    }
}
