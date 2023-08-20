package org.nagyza.cardealer.service;

import org.nagyza.cardealer.dto.UserDTO;
import org.nagyza.cardealer.model.security.User;
import org.nagyza.cardealer.repository.UserRepository;
import org.nagyza.cardealer.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find user."));

        return UserDetailsImpl.build(user);
    }

    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username or email was incorrect."));

        return new UserDTO(user);
    }

    public User loadTestUser() {

        User user = new User("nagyza", "pp", "nagyza@gmail.com");
        User savedUser;
        if (!userRepository.existsByUsername(user.getUsername())) {
            savedUser = userRepository.save(user);
        } else {
            savedUser = userRepository.findByUsername(user.getUsername()).orElseThrow(RuntimeException::new);
        }
        return savedUser;
    }

    private Collection<? extends GrantedAuthority> mapToSpringAuthorities(String role) {
        if (role != null && !role.isEmpty()) {
            return Set.of(new SimpleGrantedAuthority(role));
        } else {
            return Set.of();
        }
    }
}
