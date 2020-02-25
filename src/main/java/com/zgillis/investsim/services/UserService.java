//package com.zgillis.investsim.services;
//
//import com.zgillis.investsim.entities.UserAccount;
//import com.zgillis.investsim.repositories.UserAccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    UserAccountRepository userAccountRepository;
//
//    public UserAccount loginUsernamePassword(String username, String password) {
//        return userAccountRepository.findByUsernameAndPassword(username, password);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserAccount account = userAccountRepository.findByUsername(username);
//        UserDetails x = new User(account.getUsername(), account.getPassword(), new ArrayList<>());
//        return x;
//    }
//}
