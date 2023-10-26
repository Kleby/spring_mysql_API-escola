package com.jkompany.generation_brasil.services.servicoAlunoImpl;

import com.jkompany.generation_brasil.models.Aluno;
import com.jkompany.generation_brasil.repository.RepositorioAluno;
import com.jkompany.generation_brasil.services.ServicoAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoAlunoImpl implements ServicoAluno {

    @Autowired
    private final RepositorioAluno repositorioAluno;

    public ServicoAlunoImpl(RepositorioAluno repositorioAluno) {
        this.repositorioAluno = repositorioAluno;
    }


    @Override
    public Aluno buscarAluno(Long id) {
        Aluno aluno = repositorioAluno.findById(id).orElseThrow(null);
        return aluno;
    }

    @Override
    public Aluno adicionarAluno(Aluno aluno) {
        return repositorioAluno.save(aluno);
    }

    @Override
    public List<Aluno> mostrarAlunos() {
        return repositorioAluno.findAll();
    }

    @Override
    public void apagarAluno(Long id) {
        repositorioAluno.deleteById(id);
    }

    @Override
    public Aluno atualizarAluno(Aluno aluno, Long id) {
        var alunoBd = buscarAluno(id);
        alunoBd = aluno;
        repositorioAluno.save(alunoBd);
        return alunoBd;
    }
}
