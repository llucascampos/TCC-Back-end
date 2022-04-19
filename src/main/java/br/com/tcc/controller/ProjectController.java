package br.com.tcc.controller;

import br.com.tcc.DTO.*;
import br.com.tcc.service.PhaseService;
import br.com.tcc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAll(@RequestParam(required = false) String nome) {
        final var projectsDto = projectService.getAll(nome);
        return ResponseEntity.ok().body(projectsDto);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProjectDTO projectRequestDTO){
        projectService.registerNewProject(projectRequestDTO);
        return ResponseEntity.ok().body("");
    }

    @PutMapping
    public ResponseEntity<?> updateStatus(@RequestBody UpdateRequestDTO updateRequestDTO) {
        this.projectService.updateStatus(updateRequestDTO);
        return ResponseEntity.ok().body("");
    }

    @GetMapping(value = "/{idProject}")
    public ResponseEntity<ProjectDTO> getById(@PathVariable Long idProject) {
        final var projectDTO = projectService.getProjectById(idProject);
        return ResponseEntity.ok().body(projectDTO);
    }

}
