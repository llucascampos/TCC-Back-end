package br.com.tcc.mapper;

import br.com.tcc.DTO.PhaseDTO;
import br.com.tcc.DTO.PriorityLevelDTO;
import br.com.tcc.entity.Phase;
import br.com.tcc.entity.PriorityLevel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface PriorityMapper {

    PriorityLevelDTO toDto(PriorityLevel priorityLevel);

    List<PriorityLevelDTO> toDtoList(List<PriorityLevel> priorityLevelList);

    PriorityLevel toModel(PriorityLevelDTO priorityLevelDTO);
}
