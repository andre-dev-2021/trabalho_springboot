package br.com.gdb.trabalho_springboot.util.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponseDTO(
    LocalDateTime timestamp,
    int status,
    String mensagem,
    List<String> erros
) {
    
    public ErrorResponseDTO(int status, String mensagem){
        this(LocalDateTime.now(), status, mensagem, null);
    }

    public ErrorResponseDTO(int status, String mensagem, List<String> erros){
        this(LocalDateTime.now(), status, mensagem, erros);
    }

}
