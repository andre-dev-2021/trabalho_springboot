package br.com.gdb.trabalho_springboot.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import br.com.gdb.trabalho_springboot.util.exceptions.ResourceNotFoundException;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<Professor> findAll() {
        return repository.findAll();
    }

    public Professor findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado."));
    }

    public void save(ProfessorRequestDTO request) {
        Professor professor = new Professor(
                request.nome(),
                request.email(),
                request.departamento()
        );

        repository.save(professor);
    }
}
