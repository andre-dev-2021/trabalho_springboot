package br.com.gdb.trabalho_springboot.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import br.com.gdb.trabalho_springboot.util.exceptions.*;
import br.com.gdb.trabalho_springboot.professor.Professor;
import br.com.gdb.trabalho_springboot.professor.ProfessorRepository;

@Service 
public class CursoService {
    
    @Autowired 
    private CursoRepository repository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<CursoResponseDTO> findAll(){
        return repository.findAll()
            .stream()
            .map(curso -> new CursoResponseDTO(
                    curso.getId(),
                    curso.getProfessor() != null ? curso.getProfessor().getId() : null,
                    curso.getNome()
            ))
            .toList();
    }

    public List<CursoResponseDTO> findByProfessorID(Integer idProfessor){
        return repository.findByProfessorID(idProfessor)
            .stream()
            .map(curso -> new CursoResponseDTO(
                    curso.getId(),
                    curso.getProfessor() != null ? curso.getProfessor().getId() : null,
                    curso.getNome()
            ))
            .toList();
    }

    public Curso findById(Integer id){
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado."));
    }

    public void save(CursoRequestDTO request){
        Professor professor = professorRepository.findById(request.idProfessor())
            .orElseThrow(() -> new InvalidReferenceException("O professor com ID " + request.idProfessor() + " não existe."));

        Curso curso = new Curso(
            request.nome(),
            professor
        );

        repository.save(curso);
    }
    
}
