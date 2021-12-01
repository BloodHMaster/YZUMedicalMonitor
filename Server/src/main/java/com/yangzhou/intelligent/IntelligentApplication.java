package com.yangzhou.intelligent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(value = "com.yangzhou.intelligent.mapper")
public class IntelligentApplication extends SpringBootServletInitializer implements CommandLineRunner {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IntelligentApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(IntelligentApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动成功");
    }

}
