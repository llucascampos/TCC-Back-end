package br.com.tcc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "TASK_DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "ID_USER_RESPONSIBLE")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ID_PROJECT")
    private Project project;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "END_DATE")
    private Timestamp endDate;

    @Column(name = "EXPECTED_END_DATE")
    private Timestamp expectedEndDate;

    @OneToOne
    @JoinColumn(name = "ID_PRIORITY_LEVEL")
    private PriorityLevel priorityLevel;

   // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_PHASE")
    private Phase phase;

    @OneToOne
    @JoinColumn(name = "ID_STATUS")
    private Status status;

}
