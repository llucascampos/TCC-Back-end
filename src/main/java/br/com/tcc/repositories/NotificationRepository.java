package br.com.tcc.repositories;

import br.com.tcc.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {


    @Query("select n from Notification n where n.user.id = :userId")
    List<Notification> findByUser(@Param("userId") Long userId);

    @Modifying
    Notification save(Notification notification);

}
