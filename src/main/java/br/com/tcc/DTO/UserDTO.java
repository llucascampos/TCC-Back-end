package br.com.tcc.DTO;

import br.com.tcc.entity.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String telephoneNumber;
    private String perfilUser;
    private Long projectId;
    private String projectName;

    @JsonIgnore
    private String password;
}
