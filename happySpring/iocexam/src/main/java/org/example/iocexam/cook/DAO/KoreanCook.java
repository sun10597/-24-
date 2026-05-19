package org.example.iocexam.cook.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public class KoreanCook implements Cook {
    @Override
    public void cook() {
        System.out.println("비빔밥을 만듭니다.");
    }
}
