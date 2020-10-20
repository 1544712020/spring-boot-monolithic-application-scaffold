package com.lwz.web.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * PageHelper插件配置
 * @author Lw中
 * @date 2020/9/11 19:48
 */

@Configuration
public class PageHelpConfig {

    @Bean
    public PageHelper createPageHelper() {
        PageHelper pageHelper = new PageHelper();
        return pageHelper;
    }

}
