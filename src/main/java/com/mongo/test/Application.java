package com.mongo.test;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.mongo.test")
@ImportResource("mongo-data.xml")
public class Application {

    protected Application() {
        super();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }
}
