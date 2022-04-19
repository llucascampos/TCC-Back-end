package br.com.tcc.controller;

import br.com.tcc.DTO.*;
import br.com.tcc.service.PerfilService;
import br.com.tcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        final var userDTOList = userService.getAll();
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping("/{emailUser}")
    public ResponseEntity<UserDTO> getUsersByEmail(@PathVariable String emailUser ) {
        final var userDTO = userService.getUserByEmail(emailUser);
        return ResponseEntity.ok().body(userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ResponseEntity<?> newUser(@RequestBody UserDTO userDTO){
        userService.saveNewUser(userDTO);
        return ResponseEntity.ok().body("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("");
    }

    @GetMapping("/perfil")
    public ResponseEntity<List<PerfilDTO>> getAll(){
        final var perfilDtoList = perfilService.getAll();
        return ResponseEntity.ok().body(perfilDtoList);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<InfoHomeDTO> getInfoHome(@PathVariable Long id){
        final var infoHome = userService.getHome(id);
        return ResponseEntity.ok().body(infoHome);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/password")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordDTO updatePasswordDTO){
        userService.updatePassword(updatePasswordDTO);
        return ResponseEntity.ok().body("");
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/project")
    public ResponseEntity<?> updateProject(@RequestBody UpdateProjectUserDTO updateProjectUserDTO){
        userService.updateProject(updateProjectUserDTO);
        return ResponseEntity.ok().body("");
    }
}
