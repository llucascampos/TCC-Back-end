package br.com.tcc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME_USER", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false, unique=true)
    private String email;

    @Column(name = "TELEPHONE_NUMBER", nullable = false)
    private String telephoneNumber;

    @JsonIgnore
    @Column(name = "PASSWORD")
    private String password;

    @OneToOne
    @JoinColumn(name = "ID_PERFIL", nullable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "ID_PROJECT")
    private Project project;

    @OneToMany(mappedBy = "user")
    @Column(name = "ID_TASK")
    private List<Task> tasks;

    @OneToMany(mappedBy = "user")
    @Column(name = "ID_NOTIFICATION")
    private List<Notification> notifications;

}
