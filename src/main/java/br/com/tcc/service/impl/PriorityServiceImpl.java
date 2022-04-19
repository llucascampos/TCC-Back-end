package br.com.tcc.service.impl;

import br.com.tcc.DTO.PriorityLevelDTO;
import br.com.tcc.mapper.PriorityMapper;
import br.com.tcc.repositories.PriorityRepository;
import br.com.tcc.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityServiceImpl  implements PriorityService {

    @Autowired
    PriorityRepository priorityRepository;

    @Autowired
    PriorityMapper priorityMapper;

    public List<PriorityLevelDTO> getAll() {

        final var priorityLevel = priorityRepository.findAll();
        final var priorityDto = priorityMapper.toDtoList(priorityLevel);
        return priorityDto;
    }
}
