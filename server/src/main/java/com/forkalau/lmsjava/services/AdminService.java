package com.forkalau.lmsjava.services;

import com.forkalau.lmsjava.domain.Admin;
import com.forkalau.lmsjava.repositories.ILoginRepository;
import com.forkalau.lmsjava.services.iservices.IFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private ILoginRepository loginRepository;

    @Autowired
    IFactory factory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = loginRepository.findByUsername(username);
        if(user==null) factory.usernameNotFoundException("User not found");
        return user;
    }


    @Transactional
    public Admin loadUserById(Long id){
        Admin user = loginRepository.getById(id);
        if(user==null) factory.usernameNotFoundException("User not found");
        return user;

    }
}
