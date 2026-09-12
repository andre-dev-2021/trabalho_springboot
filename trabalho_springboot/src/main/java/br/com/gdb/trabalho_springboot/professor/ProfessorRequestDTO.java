package br.com.gdb.trabalho_springboot.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorRequestDTO(

        @NotBlank(message = "É necessário informar um nome.")
        @Size(min = 3, max = 100, message = "O campo 'nome' deve ter entre 3 e 100 caracteres.")
        String nome,

        @NotBlank(message = "É necessário informar um email.")
        @Email(message = "O campo 'email' está no formato incorreto.")
        @Size(min = 3, max = 100, message = "O campo 'email' deve ter entre 3 e 100 caracteres.")
        String email,

        @Size(min = 3, max = 50, message = "O campo 'departamento' deve ter entre 3 e 50 caracteres.")
        String departamento
) {}
