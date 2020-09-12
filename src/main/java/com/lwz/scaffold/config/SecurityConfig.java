package com.lwz.scaffold.config;

import com.lwz.scaffold.filter.JwtAuthorizationFilter;
import com.lwz.scaffold.jwt.JwtAuthenticationSuccessHandler;
import com.lwz.scaffold.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

/**
 * @author Lw中
 * @date 2020/9/12 16:51
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /** 注入userService实例 */
    @Autowired
    UserService userService;

    @Autowired
    private JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;

    /**
     * 用于设置用户权限继承
     * @return
     */
    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return roleHierarchy;
    }

    /**
     * 注入加密方法
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordConfig();
    }

    /**
     * 此方法用来认证相关builder，用来配置全局的认证相关信息
     * 它包含AuthenticationProvider、UserDetailsService：前者是认证服务提供者，后者是用户详情查询
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 此方法不是基于内存，也不是基于 JdbcUserDetailsManager，而是使用自定义的 UserService。
        // 通过userService作为参数
        // .passwordEncoder()保证用户登录时使用md5对密码进行处理再与数据库中的密码比对
        auth.userDetailsService(userService).passwordEncoder(new PasswordConfig());
    }

    /**
     * 配置不需要拦截文件目录
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/cs/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .successHandler(jwtAuthenticationSuccessHandler)
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(e.getMessage());
                    out.flush();
                    out.close();
                })
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("注销成功");
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                // 如果csrf保护开启了，就需要提交token信息
                .csrf().disable().exceptionHandling()
                .authenticationEntryPoint((req, resp, authException) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter out = resp.getWriter();
                            out.write(authException.getMessage());
                            out.flush();
                            out.close();
                        }
                )
                .and()
                // 使用jwt之后，不使用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 添加JWT过滤器 除已配置的其它请求都需经过此过滤器
                .addFilter(new JwtAuthorizationFilter(authenticationManager()));
    }
}
