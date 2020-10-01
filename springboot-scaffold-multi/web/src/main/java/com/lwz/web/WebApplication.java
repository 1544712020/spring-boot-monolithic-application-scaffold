package com.lwz.web;

import com.lwz.web.config.RedisConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 15447
 */
@EnableCaching
@Import(RedisConfig.class)
@EnableSwagger2
@SpringBootApplication
@MapperScan(basePackages = "com.lwz.web.dao")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
