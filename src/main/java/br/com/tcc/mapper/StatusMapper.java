package br.com.tcc.mapper;

import br.com.tcc.DTO.StatusDTO;
import br.com.tcc.DTO.UserDTO;
import br.com.tcc.entity.Status;
import br.com.tcc.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface StatusMapper {

    StatusDTO toDto(Status status);

    List<StatusDTO> toDtoList(List<Status> statusList);

    Status toModel(StatusDTO statusDTO);
}
