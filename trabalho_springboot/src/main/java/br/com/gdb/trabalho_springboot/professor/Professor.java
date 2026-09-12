package br.com.gdb.trabalho_springboot.professor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "professor")
@Getter
@Setter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String departamento;

    public Professor() {
    }

    public Professor(String nome, String email, String departamento) {
        this.nome = nome;
        this.email = email;
        this.departamento = departamento;
    }
}
