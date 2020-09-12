package com.lwz.scaffold.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwz.scaffold.util.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * @author Lw中
 * @date 2020/9/1 17:32
 */

@Component
public class JwtAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != null && principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            request.getSession().setAttribute("userDetail", user);
            String role = "";
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            for (GrantedAuthority authority : authorities){
                role = authority.getAuthority();
            }


            String token = JwtTokenUtils.createToken(user.getUsername(), role);
            System.out.println("role："+role);
            System.out.println("token：" + token);

            //  String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
            // 返回创建成功的token
            // 但是这里创建的token只是单纯的token
            // 按照jwt的规定，最后请求的时候应该是 `Bearer token`

            response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(new ObjectMapper().writeValueAsString(principal));
            out.flush();
            out.close();
        }
    }
}
