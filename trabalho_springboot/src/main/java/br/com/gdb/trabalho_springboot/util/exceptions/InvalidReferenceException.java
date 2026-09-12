package br.com.gdb.trabalho_springboot.util.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_CONTENT)
public class InvalidReferenceException extends RuntimeException{
    public InvalidReferenceException (String message){
        super(message);
    }
}