package br.com.tcc.mapper;

import br.com.tcc.DTO.ProjectDTO;
import br.com.tcc.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface ProjectMapper {

    @Mapping(target = "id", source="id")
    @Mapping(target = "description", source="description")
    ProjectDTO toDto(Project project);

    List<ProjectDTO> toDtoList(List<Project> projectList);

    @Mapping(target = "name",   source = "projectDTO.name")
    @Mapping(target = "status", source = "projectDTO.status")
    @Mapping(target = "manager", source = "projectDTO.manager")
    @Mapping(target = "description", source = "projectDTO.description")
    Project toModel(ProjectDTO projectDTO);
}
