package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bin.MyBean;
import sample.config.MyConfig;

public class MyExam01 {
    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        myBean.setName("Kim");
        System.out.println(myBean.getName());

        System.out.println("공장 생성전");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("공장 생성후");

        MyBean bean1 = (MyBean) context.getBean("myBean",MyBean.class);
        bean1.setName("kim");
        System.out.println(bean1.getName());

    }
}
