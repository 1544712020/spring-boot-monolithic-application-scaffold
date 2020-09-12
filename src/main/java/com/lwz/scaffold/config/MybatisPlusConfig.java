package com.lwz.scaffold.config;

//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Lw中
 * @date 2020/6/19 21:27
 */

@Configuration
@EnableTransactionManagement
@ComponentScan("com.lwz.scaffold.dao")
public class MybatisPlusConfig {

//    /**
//     * 配置mybatisPlus的分页插件
//     * @return
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        return paginationInterceptor;
//    }

}
