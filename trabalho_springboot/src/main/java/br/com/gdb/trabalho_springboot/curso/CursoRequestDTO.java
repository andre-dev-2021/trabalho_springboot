package br.com.gdb.trabalho_springboot.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CursoRequestDTO(

    @NotBlank(message = "É necessário informar um nome.")
    @Size(min = 3, max = 100, message = "O campo 'nome' deve ter entre 3 e 100 caracteres.")
    String nome,

    @NotNull(message = "É necessário informar o id do professor.")
    Integer idProfessor
    
) {}
