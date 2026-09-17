package br.com.gdb.trabalho_springboot.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

public record AlunoRequestDTO(

    @NotBlank(message = "É necessário informar um nome.")
    @Size(min = 3, max = 100, message = "O campo 'nome' deve ter entre 3 e 100 caracteres.")
    String nome,

    @NotBlank(message = "É necessário informar um email.")
    @Email(message = "O campo 'email' está no formato incorreto.")
    @Size(min = 3, max = 100, message = "O campo 'email' deve ter entre 3 e 100 caracteres.")
    String email,

    @NotNull(message = "É necessário informar o id do curso.")
    Integer curso_id
){}