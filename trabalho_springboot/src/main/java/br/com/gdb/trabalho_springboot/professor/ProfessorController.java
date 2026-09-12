package br.com.gdb.trabalho_springboot.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @GetMapping
    public List<Professor> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Professor findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody ProfessorRequestDTO request) {
        service.save(request);
    }
}
