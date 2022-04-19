package br.com.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.tcc.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    @Query("select u from User u where u.project.id = :id")
    List<User> findByProject(@Param("id") Long id);

    User findByEmail(String email);

    User save(User user);

    void deleteById(Long id);

    Optional<User> findById(Long id);


    @Modifying
    @Query(value = "UPDATE TB_USER SET PASSWORD = :newPassword  WHERE ID = :id ", nativeQuery = true)
    void updatePassword(@Param("newPassword") String newPassword,
                        @Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE TB_USER SET ID_PROJECT = :project  WHERE ID = :id ", nativeQuery = true)
    void updateIdproject(@Param("project") Long project,
                        @Param("id") Long id);

}
