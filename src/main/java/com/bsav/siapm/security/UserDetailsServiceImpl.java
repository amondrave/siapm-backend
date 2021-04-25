package com.bsav.siapm.security;

import com.bsav.siapm.entities.User;
import com.bsav.siapm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String document) throws UsernameNotFoundException {
        User user = userRepository.findByDocument(document)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with document: " + document));

        return UserDetailsImpl.build(user);
    }

    public List<UserDetails> getUsers() {
        List<UserDetails> details = new ArrayList<>();
        List<User> users = userRepository.findAll();
        users.forEach(u -> details.add(UserDetailsImpl.build(u)));
        return details;
    }


}

