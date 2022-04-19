package br.com.tcc.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private UserDTO user;
    private Timestamp createDate;
    private Timestamp expectedEndDate;
    private PriorityLevelDTO priorityLevel;
    private StatusDTO status;
    private Long idPhase;

}
