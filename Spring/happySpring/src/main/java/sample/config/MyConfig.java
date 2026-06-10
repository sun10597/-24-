package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample.bin.MyBean;
@Configuration
public class MyConfig {
    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
}
