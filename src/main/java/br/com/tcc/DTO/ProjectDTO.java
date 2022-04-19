package br.com.tcc.DTO;

import br.com.tcc.entity.Phase;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class ProjectDTO {

    private Long id;
    private String name;
    private String description;
    private UserDTO manager;
    private Timestamp startDate;
    private List<PhaseDTO> phases;
    private StatusDTO status;

}
