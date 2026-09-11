package br.com.gdb.trabalho_springboot.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorRequestDTO(

        @NotBlank(message = "É necessário informar um nome.")
        String nome,

        @NotBlank(message = "É necessário informar um email.")
        @Email(message = "O campo 'email' está no formato incorreto.")
        String email,

        @Size(min = 3, max = 50, message = "O campo 'departamento' deve ter entre 3 e 50 caracteres.")
        String departamento
) {}
