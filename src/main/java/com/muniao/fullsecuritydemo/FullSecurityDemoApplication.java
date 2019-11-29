package com.muniao.fullsecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FullSecurityDemoApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(FullSecurityDemoApplication.class, args);
    }

}
