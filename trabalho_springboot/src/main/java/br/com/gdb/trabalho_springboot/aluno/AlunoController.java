package br.com.gdb.trabalho_springboot.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController 
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<AlunoResponseDTO> findAll( @RequestParam(required = false) Integer curso_id ){        
        if(curso_id != null){
            return service.findByCursoID(curso_id);
        }

        return service.findAll();
    }

    @GetMapping("/{id}")
    public Aluno findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody AlunoRequestDTO request) {
        service.save(request);
    }
    
}