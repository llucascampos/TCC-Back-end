package br.com.tcc.service;

import br.com.tcc.DTO.TaskDTO;
import br.com.tcc.DTO.UpdateRequestDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface TaskService {

    List<TaskDTO> getAllByPhase(Long idPhase);

    void CreateNewTask(TaskDTO taskDTO);

    void updateStatus(UpdateRequestDTO updateRequestDTO);

}
