package br.com.tcc.service;

import br.com.tcc.DTO.ProjectDTO;
import br.com.tcc.DTO.UpdateRequestDTO;
import br.com.tcc.entity.Project;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public interface ProjectService {

    public List<ProjectDTO> getAll(String nome);

    public void registerNewProject(ProjectDTO projectDTO);

    void updateStatus(UpdateRequestDTO updateRequestDTO);

    public ProjectDTO getProjectById(Long id);

}
