package br.com.tcc.service.impl;

import br.com.tcc.DTO.ProjectDTO;
import br.com.tcc.DTO.UpdateRequestDTO;
import br.com.tcc.entity.Project;
import br.com.tcc.mapper.ProjectMapper;
import br.com.tcc.repositories.ProjectRepository;
import br.com.tcc.repositories.UserRepository;
import br.com.tcc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void registerNewProject(ProjectDTO projectDTO) {
        final var project = projectMapper.toModel(projectDTO);
        var prj = projectRepository.save(project);

        userRepository.updateIdproject(prj.getId(), projectDTO.getManager().getId());
    }

    @Override
    public List<ProjectDTO> getAll(String name) {
        List<Project> projects = new ArrayList<>();
        if(name != null) {
            projects = projectRepository.findByName(name);
        }else {
            projects = projectRepository.findAll();
        }

        final var projecstDto = projectMapper.toDtoList(projects);
        return projecstDto;
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        final var project = projectRepository.findProjectById(id);
        final var projectDto = projectMapper.toDto(project);
        return projectDto;
    }

    @Override
    public void updateStatus(UpdateRequestDTO updateRequestDTO){
        var users = userRepository.findByProject(updateRequestDTO.getId());
        users.forEach( u-> {
            userRepository.updateIdproject(null, u.getId());
        });
        projectRepository.updateStatus(updateRequestDTO.getStatus(), updateRequestDTO.getId());

    }

}


