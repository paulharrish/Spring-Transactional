package com.example;

import com.example.config.Appconfig;
import com.example.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        context.registerShutdownHook();

        ProductService productService = context.getBean("productService", ProductService.class);
        productService.saveProductnfo();

        context.close();
    }
}