package com.vicevini.JavaDocker.tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaFacade {
    @Autowired
    private TarefaRepository repository;
    @Autowired
    private TarefaQueryRepository queryRepository;

    public TarefaDTO criar(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setPrioridade(tarefaDTO.getPrioridade());
        tarefa.setUsuario(tarefaDTO.getUsuario());
        repository.save(tarefa);
        tarefaDTO.setId(tarefa.getId());
        return  tarefaDTO;
    }

    public TarefaDTO atualizar (TarefaDTO tarefaDTO, Long tarefaId) {
        Tarefa tarefaDatabase = repository.getOne(tarefaId);
        tarefaDatabase.setTitulo(tarefaDTO.getTitulo());
        tarefaDatabase.setDescricao(tarefaDTO.getDescricao());
        tarefaDatabase.setPrioridade(tarefaDTO.getPrioridade());
        repository.save(tarefaDatabase);
        return tarefaDTO;
    }

    private TarefaDTO converter (Tarefa tarefa) {
        TarefaDTO result = new TarefaDTO();
        result.setId(tarefa.getId());
        result.setTitulo(tarefa.getTitulo());
        result.setDescricao(tarefa.getDescricao());
        return result;
    }

    public List<TarefaDTO> getAll () {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public String delete (Long tarefaId) {
        repository.deleteById(tarefaId);
        return "DELETED";
    }

    private  void metodosQuery(){
        Pageable pageable = PageRequest.of(0,5, Sort.by("prioridade").descending() );
        List<Tarefa> tarefas = repository.findByUsuario("vini", pageable);
    }
}