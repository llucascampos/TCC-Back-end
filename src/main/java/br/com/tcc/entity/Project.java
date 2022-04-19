package br.com.tcc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME_PROJECT")
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

    @OneToOne
    @JoinColumn(name = "ID_USER_MANAGER")
    private User manager;

    @OneToMany(mappedBy = "project", cascade = CascadeType.MERGE)
    private List<User> members;

    @OneToMany(mappedBy = "project", cascade = CascadeType.MERGE)
    private List<Phase> phases;

}
