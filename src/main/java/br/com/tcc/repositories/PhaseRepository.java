package br.com.tcc.repositories;

import br.com.tcc.entity.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Long> {

    @Query("select p from Phase p where p.project.id = :idProject")
    List<Phase> findByProject( @Param("idProject") Long idProject);

    List<Phase> findAll();


    @Query("select p from Phase p where p.id = :id")
    Phase findPhaseById(@Param("id") Long id);

    Phase save(Phase phase);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TB_PHASE set ID_STATUS = :status where id = :id", nativeQuery = true)
    void updateStatus(@Param("status") Long status, @Param("id") Long id);

}
