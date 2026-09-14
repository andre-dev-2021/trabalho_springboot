package br.com.gdb.trabalho_springboot.aluno;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import br.com.gdb.trabalho_springboot.curso.Curso;

@Entity
@Table(name = "aluno")
@Getter 
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Aluno(){
    }

    public Aluno(String nome, String email, Curso curso){
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }
    
}