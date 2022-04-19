package br.com.tcc.service.impl;

import br.com.tcc.repositories.UserRepository;
import br.com.tcc.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final var user = userRepository.findByEmail(email);

        if (user == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(user.getId(), user.getEmail(), user.getPassword(), user.getPerfil());
    }
}
