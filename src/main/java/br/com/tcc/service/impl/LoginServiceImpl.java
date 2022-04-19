package br.com.tcc.service.impl;

import br.com.tcc.DTO.LoginDTO;
import br.com.tcc.DTO.UserDTO;
import br.com.tcc.entity.User;
import br.com.tcc.mapper.UserMapper;
import br.com.tcc.repositories.UserRepository;
import br.com.tcc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO login(LoginDTO login){
        var user =  userRepository.findByEmail(login.getEmail());

        if(user != null){
            if(user.getPassword().equals(login.getPassword())){
                return userMapper.toDto(user);
            }
            else {
                return new UserDTO();
            }
        }else{
            return null;
        }

    }

    public Boolean firstAccess(User user ){
        if (user.getPassword() == null){
            return true ;
        }else {
            return false;
        }
    }
}
