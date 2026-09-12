package br.com.gdb.trabalho_springboot.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.com.gdb.trabalho_springboot.util.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import java.util.List;
import br.com.gdb.trabalho_springboot.util.exceptions.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidReferenceException.class)
    public ResponseEntity<ErrorResponseDTO> handleReferenceException(InvalidReferenceException ex){

        ErrorResponseDTO error = new ErrorResponseDTO(
            HttpStatus.UNPROCESSABLE_CONTENT.value(), 
            ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceException(ResourceNotFoundException ex){
        
        ErrorResponseDTO error = new ErrorResponseDTO(
            HttpStatus.NOT_FOUND.value(), 
            ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationException(MethodArgumentNotValidException ex){
        
	List<String> erros = ex.getBindingResult().getFieldErrors().stream()
		.map(fe -> fe.getDefaultMessage())
		.toList();

        ErrorResponseDTO error = new ErrorResponseDTO(
            HttpStatus.BAD_REQUEST.value(),
            "Erro de validação",
	    erros
        );

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralException(Exception ex){
	
	ErrorResponseDTO error = new ErrorResponseDTO(
		HttpStatus.INTERNAL_SERVER_ERROR.value(),
		"Erro interno no servidor"
	);

	return ResponseEntity.internalServerError().body(error);
    }
}
