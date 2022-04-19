package br.com.tcc.repositories;

import br.com.tcc.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAll();

    List<Project> findByName(String name);

    @Query("select p from Project p where p.id =:id")
    Project findProjectById(@Param("id")Long id);

    Project save(Project project);

    @Modifying
    @Query(value = "UPDATE TB_PROJECT set ID_STATUS = :status where id = :id", nativeQuery = true)
    void updateStatus(@Param("status") Long status, @Param("id") Long id);

    void deleteById(Long id);


}
