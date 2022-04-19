package br.com.tcc.service;

import br.com.tcc.DTO.LoginDTO;
import br.com.tcc.DTO.UserDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public interface LoginService {

    UserDTO login(LoginDTO login);

}
