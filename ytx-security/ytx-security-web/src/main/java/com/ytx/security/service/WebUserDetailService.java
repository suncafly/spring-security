package com.ytx.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * MyUserDetailService
 *
 * @author LiFang
 * @date 2018-10-13 5:05 PM
 * @since
 */
@Component
public class WebUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("login username：" + userName);
        String password = passwordEncoder.encode("123456");
        System.out.println(password);
        return new User(userName, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
