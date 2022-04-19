package br.com.tcc.service.impl;

import br.com.tcc.DTO.*;
import br.com.tcc.mapper.UserMapper;
import br.com.tcc.repositories.UserRepository;
import br.com.tcc.service.NotificationService;
import br.com.tcc.service.ProjectService;
import br.com.tcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    NotificationService notificationService;

    @Autowired
    ProjectService projectService;

    @Autowired
    BCryptPasswordEncoder pe;

    @Override
    public List<UserDTO> getAll(){
        final var userList = userRepository.findAll();
        final var userDTOList = userMapper.toDtoList(userList);
        return userDTOList;
    }

    @Override
    public UserDTO getUserByEmail(String emailUser) {
        final var user = userRepository.findByEmail(emailUser);
        final var userDto = userMapper.toDto(user);

        return userDto;
    }

    @Override
    public void saveNewUser(UserDTO userDTO) {
        userDTO.setPassword(pe.encode("123"));
        final var user = userMapper.toModel(userDTO);
        final var res = userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void updatePassword(UpdatePasswordDTO updatePasswordDTO){
        final var user = userRepository.findById(updatePasswordDTO.getId());
        userRepository.updatePassword(pe.encode(updatePasswordDTO.getNewPassword()), updatePasswordDTO.getId());
    }

    @Override
    public void updateProject(UpdateProjectUserDTO updateProjectUserDTO){
        userRepository.updateIdproject(updateProjectUserDTO.getIdProject(), updateProjectUserDTO.getIdUser());

        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setUser(updateProjectUserDTO.getIdUser());
        notificationDTO.setCreateDate(new Timestamp(new Date().getTime()));
        notificationDTO.setMessage("Você foi adicionado a um novo projeto");
        notificationService.saveNewNotification(notificationDTO);
    }

    public InfoHomeDTO getHome(Long id) {
        InfoHomeDTO infoHomeDTO = new InfoHomeDTO();

        final var user = userRepository.findById(id);
        if(user.get().getProject() != null){
            var project = projectService.getProjectById(user.get().getProject().getId());
          //  var phaseActive = project.getPhases().stream().filter( p-> p.getStatus().getId() == 5);
            infoHomeDTO.setProject(project.getName());
            infoHomeDTO.setProjectId(project.getId());
          //  infoHomeDTO.setNTask(0);
        }

        var notification = notificationService.getAllByUser(id).size();
        infoHomeDTO.setNNotification(notification);

        return infoHomeDTO;
    }
}
