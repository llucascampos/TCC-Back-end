package br.com.tcc.service.impl;

import br.com.tcc.DTO.NotificationDTO;
import br.com.tcc.DTO.TaskDTO;
import br.com.tcc.DTO.UpdateRequestDTO;
import br.com.tcc.entity.Task;
import br.com.tcc.mapper.TaskMapper;
import br.com.tcc.repositories.TaskRepository;
import br.com.tcc.service.NotificationService;
import br.com.tcc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    NotificationService notificationService;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public List<TaskDTO> getAllByPhase(Long idPhase){
        final var taskList = taskRepository.findByPhase(idPhase);
        final var taskListDto = taskMapper.toDtoList(taskList);
        return taskListDto;
    }

    public void CreateNewTask(TaskDTO taskDTO) {
        final var task = taskMapper.toModel(taskDTO);
        taskRepository.save(task);

        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setUser(taskDTO.getUser().getId());
        notificationDTO.setCreateDate(new Timestamp(new Date().getTime()));
        notificationDTO.setMessage("Foi criado uma nova tarefa em seu nome");
        notificationService.saveNewNotification(notificationDTO);
    }

    @Override
    public void updateStatus(UpdateRequestDTO updateRequestDTO){
        taskRepository.updateStatus(updateRequestDTO.getStatus(), updateRequestDTO.getId());
    }

    private void verifyStatus() throws ParseException {
        final var taskList = taskRepository.findAll();

        for (Task task: taskList) {
            var data = new Date(task.getExpectedEndDate().getTime());
            var today = new Date();

            if(data.after(today)){
                taskRepository.updateStatus(7l, task.getId());
            }

        }
    }
}
