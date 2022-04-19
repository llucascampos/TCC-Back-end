package br.com.tcc.DTO;

import br.com.tcc.entity.Status;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class PhaseDTO {

    private Long id;
    private String name;
    private String description;
    private Timestamp startDate;
    private Status status;
    private List<TaskDTO> tasks;
    private Long idProject;
}
