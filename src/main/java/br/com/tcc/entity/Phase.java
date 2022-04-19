package br.com.tcc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_phase")
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME_PHASE")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "START_DATE")
    private Timestamp startDate;

    @Column(name = "END_DATE")
    private Timestamp endDate;

    @OneToOne
    @JoinColumn(name = "ID_STATUS")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "ID_PROJECT")
    private Project project;

    @OneToMany(mappedBy = "phase")
    private List<Task> tasks;
}
