package br.com.tcc.mapper;

import br.com.tcc.DTO.TaskDTO;
import br.com.tcc.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface TaskMapper {

    @Mapping(target = "title", source = "task.title")
    TaskDTO toDto(Task task);

    List<TaskDTO> toDtoList(List<Task> taskList);

    @Mapping(target = "phase.id", source = "taskDTO.idPhase")
    @Mapping(target = "title", source = "taskDTO.title")
    Task toModel(TaskDTO taskDTO);
}
