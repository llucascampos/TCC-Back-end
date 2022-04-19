package br.com.tcc.service;

import br.com.tcc.DTO.PriorityLevelDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface PriorityService {

    List<PriorityLevelDTO> getAll();

}
