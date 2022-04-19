package br.com.tcc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_difficulty_level")
public class DifficultyLevel {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(name = "NAME_DIFFICULTY_LEVEL")
    private String name;
}
