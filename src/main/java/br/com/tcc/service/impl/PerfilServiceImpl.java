package br.com.tcc.service.impl;

import br.com.tcc.DTO.PerfilDTO;
import br.com.tcc.mapper.PerfilMapper;
import br.com.tcc.repositories.PerfilRepository;
import br.com.tcc.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PerfilMapper perfilMapper;

    @Override
    public List<PerfilDTO> getAll(){
        final var perfilList = perfilRepository.findAll();

        var perfilListDto = perfilMapper.toDtoList(perfilList);

        return perfilListDto;
    }
}
