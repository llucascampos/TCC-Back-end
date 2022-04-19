package br.com.tcc.service;

import br.com.tcc.DTO.NotificationDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface NotificationService {

    List<NotificationDTO> getAllByUser(Long idUser);

    void saveNewNotification(NotificationDTO notificationDTO);
}
