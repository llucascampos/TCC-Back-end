package br.com.tcc.repositories;

import br.com.tcc.entity.PriorityLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityLevel, Long> {

    List<PriorityLevel> findAll();
}
