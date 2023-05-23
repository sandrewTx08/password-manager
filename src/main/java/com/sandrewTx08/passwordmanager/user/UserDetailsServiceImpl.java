package com.sandrewTx08.passwordmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userService
                .findUserByEmail(userEmail)
                .map(UserDetailsImpl::new)
                .orElseThrow();
    }

    public UserDetailsImpl getPrincipal() {
        try {
            return (UserDetailsImpl) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();
        } catch (Exception exception) {
            return null;
        }
    }
}
