package br.com.gdb.trabalho_springboot.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
   
    @Query(value = "SELECT * FROM aluno WHERE curso_id = :cursoId", nativeQuery = true)
    List<Aluno> findByCursoID(@Param("cursoId") Integer idCurso);

}