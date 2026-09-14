package br.com.gdb.trabalho_springboot.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Query(value = "SELECT * FROM curso WHERE professor_id = :professorId", nativeQuery = true)
    List<Curso> findByProfessorID(@Param("professorId") Integer idProfessor);

}
