package br.com.tcc.service.impl;

import br.com.tcc.DTO.NotificationDTO;
import br.com.tcc.mapper.NotificationMapper;
import br.com.tcc.repositories.NotificationRepository;
import br.com.tcc.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    NotificationMapper notificationMapper;

    public List<NotificationDTO> getAllByUser(Long idUser){
        final var notifications = notificationRepository.findByUser(idUser);
        final var notificationDTO = notificationMapper.toDtoList(notifications);
        return notificationDTO;
    }

    public void saveNewNotification(NotificationDTO notificationDTO){
        final var notification = notificationMapper.toModel(notificationDTO);
        notificationRepository.save(notification);

    }

}
