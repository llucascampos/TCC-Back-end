package br.com.tcc.controller;

import br.com.tcc.DTO.PerfilDTO;
import br.com.tcc.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "perfil")
@CrossOrigin("*")
public class PerfilController {

    @Autowired
    PerfilService perfilService;

//    @GetMapping
//    public ResponseEntity<List<PerfilDTO>> getAll(){
//        final var perfilDtoList = perfilService.getAll();
//
//        return ResponseEntity.ok().body(perfilDtoList);
//    }
}
