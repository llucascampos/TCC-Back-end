package br.com.tcc.service;

import br.com.tcc.DTO.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface UserService {

    List<UserDTO> getAll();

    UserDTO getUserByEmail(String emailUser);

    void saveNewUser(UserDTO userRequestDTO);

    void deleteUser(Long id);

    void updatePassword(UpdatePasswordDTO updatePasswordDTO);

    void updateProject(UpdateProjectUserDTO updateProjectUserDTO);

    InfoHomeDTO getHome(Long id);

}
