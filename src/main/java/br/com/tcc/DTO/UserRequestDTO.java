package br.com.tcc.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    private String name;
    private String email;
    private String telephoneNumber;
    private String occupation;
    private Long perfil;
}
