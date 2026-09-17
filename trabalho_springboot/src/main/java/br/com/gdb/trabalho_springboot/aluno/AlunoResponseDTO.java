package br.com.gdb.trabalho_springboot.aluno;

public record AlunoResponseDTO(
    Integer id,
    String nome,
    String email,
    Integer curso_id
){}