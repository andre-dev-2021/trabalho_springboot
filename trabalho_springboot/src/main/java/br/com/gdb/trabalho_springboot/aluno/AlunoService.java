package br.com.gdb.trabalho_springboot.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gdb.trabalho_springboot.util.exceptions.*;
import br.com.gdb.trabalho_springboot.curso.Curso;
import br.com.gdb.trabalho_springboot.curso.CursoRepository;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Aluno> findAll(){
        return repository.findAll();
    }

    public List<Aluno> findByCursoID(Integer idCurso){
        return repository.findByCursoID(idCurso);
    }

    public Aluno findById(Integer id){
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado."));
    }


    public void save(AlunoRequestDTO request){
        Curso curso = cursoRepository.findById(request.idCurso())
            .orElseThrow(() -> new InvalidReferenceException("O curso com ID " + request.idCurso() + " não existe."));

        Aluno aluno = new Aluno(
            request.nome(),
            request.email(),
            curso
        );

        repository.save(aluno);
    }
}