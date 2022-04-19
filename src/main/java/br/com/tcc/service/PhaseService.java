package br.com.tcc.service;

import br.com.tcc.DTO.PhaseDTO;
import br.com.tcc.DTO.UpdateRequestDTO;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public interface PhaseService {

    List<PhaseDTO> getAllByProject(Long idProject);

    void createNewPhase(PhaseDTO phaseDTO);

    void updateStatus(UpdateRequestDTO updateRequestDTO);

    PhaseDTO getById(Long id);

}
