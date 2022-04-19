package br.com.tcc.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePasswordDTO {

    private Long id;
    private String newPassword;

}
