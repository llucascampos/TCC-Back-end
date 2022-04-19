package br.com.tcc.controller;

import br.com.tcc.DTO.LoginDTO;
import br.com.tcc.DTO.UserDTO;
import br.com.tcc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    LoginService loginService;

//    @PostMapping
//    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO login){
//        final var userDto = loginService.login(login);
//        return ResponseEntity.ok().body(userDto);
//    }
}
