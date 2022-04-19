package br.com.tcc.DTO;

import br.com.tcc.entity.Phase;
import br.com.tcc.entity.Project;
import br.com.tcc.entity.Task;
import br.com.tcc.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class NotificationDTO {

    private Long id;
    private Long user;
    private String message;
    private Boolean visualized;
    private Timestamp createDate;
}
