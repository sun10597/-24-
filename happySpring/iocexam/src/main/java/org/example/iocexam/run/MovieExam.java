package org.example.iocexam.run;

import org.example.iocexam.config.MovieConfig;
import org.example.iocexam.controller.MovieController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MovieExam {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MovieConfig.class);
        MovieController controller = context.getBean(MovieController.class);
        controller.RegisterMoive();
    }
}
