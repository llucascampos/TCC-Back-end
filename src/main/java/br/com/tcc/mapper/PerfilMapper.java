package br.com.tcc.mapper;

import br.com.tcc.DTO.PerfilDTO;
import br.com.tcc.entity.Perfil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring")
public interface PerfilMapper {


    PerfilDTO toDto(Perfil perfil);

    List<PerfilDTO> toDtoList(List<Perfil> perfilList);

    Perfil toModel(PerfilDTO perfilDTO);
}
