package br.com.tcc.controller;

import br.com.tcc.DTO.PhaseDTO;
import br.com.tcc.DTO.PriorityLevelDTO;
import br.com.tcc.DTO.TaskDTO;
import br.com.tcc.DTO.UpdateRequestDTO;
import br.com.tcc.service.PhaseService;
import br.com.tcc.service.PriorityService;
import br.com.tcc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phase")
@CrossOrigin("*")
public class PhaseController {

    @Autowired
    PhaseService phaseService;

    @Autowired
    TaskService taskService;

    @Autowired
    PriorityService priorityService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody PhaseDTO phaseDTO){
        phaseService.createNewPhase(phaseDTO);
        return ResponseEntity.ok().body("");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PhaseDTO> getById(@PathVariable Long id) {
        final var phaseDTO = phaseService.getById(id);
        return ResponseEntity.ok().body(phaseDTO);
    }

    @PutMapping
    public ResponseEntity<?> updateStatus(@RequestBody UpdateRequestDTO updateRequestDTO) {
        this.phaseService.updateStatus(updateRequestDTO);
        return ResponseEntity.ok().body("");
    }

    @PostMapping(value = "/task")
    public ResponseEntity<?> saveTask(@RequestBody TaskDTO taskDTO) {
        taskService.CreateNewTask(taskDTO);
        return ResponseEntity.ok().body("");
    }

    @PutMapping(value = "/task")
    public ResponseEntity<?> updateTaskStatus(@RequestBody UpdateRequestDTO updateRequestDTO) {
        this.taskService.updateStatus(updateRequestDTO);
        return ResponseEntity.ok().body("");
    }

    @GetMapping(value = "/task/priority")
    public ResponseEntity<List<PriorityLevelDTO>> getAllPriorityLevel() {
        final var priorityLevelDTO = priorityService.getAll();
        return ResponseEntity.ok().body(priorityLevelDTO);
    }

}
