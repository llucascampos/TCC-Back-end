package br.com.tcc.service.impl;

import br.com.tcc.DTO.PhaseDTO;
import br.com.tcc.DTO.UpdateRequestDTO;
import br.com.tcc.mapper.PhaseMapper;
import br.com.tcc.repositories.PhaseRepository;
import br.com.tcc.service.PhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PhaseServiceImpl implements PhaseService {

    @Autowired
    PhaseRepository phaseRepository;

    @Autowired
    PhaseMapper phaseMapper;

    @Override
    public List<PhaseDTO> getAllByProject(Long idProject) {
        final var phaseList = phaseRepository.findByProject(idProject);
        final var phaseListDto = phaseMapper.toDtoList(phaseList);
        return phaseListDto;
    }

    @Override
    public void createNewPhase(PhaseDTO phaseDTO) {
        final var phase = phaseMapper.toModel(phaseDTO);
        phaseRepository.save(phase);
    }

    @Override
    public void updateStatus(UpdateRequestDTO updateRequestDTO){
        phaseRepository.updateStatus(updateRequestDTO.getStatus(), updateRequestDTO.getId());
    }

    @Override
    public PhaseDTO getById(Long id){
            final var phase = phaseRepository.findPhaseById(id);
            final var phaseDto = phaseMapper.toDto(phase);
            return phaseDto;
    }

}
