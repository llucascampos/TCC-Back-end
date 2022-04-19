package br.com.tcc.service;

import br.com.tcc.DTO.PerfilDTO;
import br.com.tcc.entity.Perfil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface PerfilService {

    List<PerfilDTO> getAll();

}
