package br.com.gdb.trabalho_springboot.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findByProfessor(Integer idProfessor);
}
