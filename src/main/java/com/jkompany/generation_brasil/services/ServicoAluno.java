package com.jkompany.generation_brasil.services;

import com.jkompany.generation_brasil.models.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicoAluno {

    Aluno buscarAluno(Long id);

    Aluno adicionarAluno(Aluno aluno);

    List<Aluno> mostrarAlunos();

    void apagarAluno(Long id);

    Aluno atualizarAluno(Aluno aluno, Long id);
}
