package br.com.gdb.trabalho_springboot.curso;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import br.com.gdb.trabalho_springboot.professor.Professor;

@Entity
@Table(name = "curso")
@Getter 
@Setter
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Curso(){
    }

    public Curso(String nome, Professor professor){
        this.nome = nome;
        this.professor = professor;
    }
    
}
