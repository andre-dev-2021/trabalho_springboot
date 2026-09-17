package br.com.gdb.trabalho_springboot.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController 
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CursoService service;

    @GetMapping
    public List<CursoResponseDTO> findAll( @RequestParam(required = false) Integer idProfessor ){        
        if(idProfessor != null){
            return service.findByProfessorID(idProfessor);
        }

        return service.findAll();
    }

    @GetMapping("/{id}")
    public Curso findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody CursoRequestDTO request) {
        service.save(request);
    }
}
