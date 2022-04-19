package br.com.tcc.controller;

import br.com.tcc.DTO.NotificationDTO;
import br.com.tcc.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notification")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<NotificationDTO>> getByUser(@PathVariable Long userId){
        final var notificationDto = notificationService.getAllByUser(userId);
        return ResponseEntity.ok().body(notificationDto);
    }
}
