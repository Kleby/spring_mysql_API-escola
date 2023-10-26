package com.jkompany.generation_brasil.controller;

import com.jkompany.generation_brasil.models.Aluno;
import com.jkompany.generation_brasil.services.ServicoAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class ControlerAluno {

    @Autowired
    private final ServicoAluno servicoAluno;

    public ControlerAluno(ServicoAluno servicoAluno) {
        this.servicoAluno = servicoAluno;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable Long id){
        var aluno = servicoAluno.buscarAluno(id);
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno>  adicionarAluno(@RequestBody Aluno aluno){
        var novoAluno = servicoAluno.adicionarAluno(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> mostrarAlunos(){
        return ResponseEntity.ok(servicoAluno.mostrarAlunos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarAluno(@PathVariable Long id){
        servicoAluno.apagarAluno(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@RequestBody Aluno aluno, @PathVariable Long id){
        var alunoAlterado = servicoAluno.atualizarAluno(aluno, id);
        return ResponseEntity.ok(alunoAlterado);
    }

}
