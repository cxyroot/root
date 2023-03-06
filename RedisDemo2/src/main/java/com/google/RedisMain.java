package com.google;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述：
 * <p>
 * author caoxiaoyang
 * date 2023-02-27
 * version
 */

@SpringBootApplication
public class RedisMain {
    public static void main(String[] args) {
        //String
        //AnnotationConfigServletWebServerApplicationContext
        SpringApplication application = new SpringApplication(RedisMain.class);
        application.run();
    }
}
