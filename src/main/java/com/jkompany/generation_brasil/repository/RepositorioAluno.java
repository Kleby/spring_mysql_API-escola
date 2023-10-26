package com.jkompany.generation_brasil.repository;

import com.jkompany.generation_brasil.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAluno extends JpaRepository<Aluno, Long> {

}
