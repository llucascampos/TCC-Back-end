package br.com.tcc.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoHomeDTO {

    private String project;
    private Long projectId;
    private Integer nTask;
    private Integer nNotification;

}
