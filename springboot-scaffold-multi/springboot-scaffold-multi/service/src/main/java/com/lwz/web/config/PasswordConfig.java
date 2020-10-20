package com.lwz.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @author Lw中
 * @date 2020/9/12 16:51
 */

@Configuration
public class PasswordConfig implements PasswordEncoder {

    /**
     * 通过md5哈希函数为用户密码加密
     * @param charSequence
     * @return
     */
    @Override
    public String encode(CharSequence charSequence) {
        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
    }

    /**
     * 用于将用户输入的密码和存储在数据库中的加密密码匹配
     * @param charSequence
     * @param s
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
    }
}
