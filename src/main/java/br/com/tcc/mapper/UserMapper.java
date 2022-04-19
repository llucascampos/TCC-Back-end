package br.com.tcc.mapper;

import br.com.tcc.DTO.PerfilDTO;
import br.com.tcc.DTO.UserDTO;
import br.com.tcc.DTO.UserRequestDTO;
import br.com.tcc.entity.Perfil;
import br.com.tcc.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface UserMapper {

    @Mapping(target = "perfilUser", source = "user.perfil.name")
    @Mapping(target = "projectId", source = "user.project.id")
    @Mapping(target = "projectName", source = "user.project.name")
    UserDTO toDto(User user);

    List<UserDTO> toDtoList(List<User> userList);


    @Mapping(target = "perfil.id", source = "userDTO.perfilUser")
//    @Mapping(target = "project.id", source = "userDTO.project.id")
    User toModel(UserDTO userDTO);
}
