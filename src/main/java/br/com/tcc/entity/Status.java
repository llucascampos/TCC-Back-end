package br.com.tcc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(name = "NAME_STATUS")
    private String name;
}
