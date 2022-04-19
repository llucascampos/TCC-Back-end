package br.com.tcc.mapper;

import br.com.tcc.DTO.NotificationDTO;
import br.com.tcc.DTO.PerfilDTO;
import br.com.tcc.entity.Notification;
import br.com.tcc.entity.Perfil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface NotificationMapper {

    @Mapping(target = "user", source = "notification.user.id")
//    @Mapping(target = "project", source = "notification.id")
//    @Mapping(target = "phase", source = "notification.id")
//    @Mapping(target = "task", source = "notification.id")
    NotificationDTO toDto(Notification notification);

    List<NotificationDTO> toDtoList(List<Notification> notificationList);

    @Mapping(target = "user.id", source = "notificationDTO.user")
//    @Mapping(target = "project.id", source = "notificationDTO.project")
//    @Mapping(target = "phase.id", source = "notificationDTO.phase")
//    @Mapping(target = "task.id", source = "notificationDTO.task")
    Notification toModel(NotificationDTO notificationDTO);
}
