package br.com.tcc.mapper;

import br.com.tcc.DTO.PerfilDTO;
import br.com.tcc.DTO.PhaseDTO;
import br.com.tcc.entity.Perfil;
import br.com.tcc.entity.Phase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface PhaseMapper {

    @Mapping(target = "idProject", source = "project.id")
    PhaseDTO toDto(Phase phase);

    List<PhaseDTO> toDtoList(List<Phase> phaseList);

    @Mapping(target = "project.id", source = "phaseDTO.idProject")
    Phase toModel(PhaseDTO phaseDTO);
}
