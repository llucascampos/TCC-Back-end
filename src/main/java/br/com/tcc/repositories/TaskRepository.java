package br.com.tcc.repositories;

import br.com.tcc.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByPhase(Long idPhase);

    Task save(Task task);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TB_TASK set ID_STATUS = :status where id = :id ", nativeQuery = true)
    void updateStatus(@Param("status") Long status, @Param("id") Long id);
}
