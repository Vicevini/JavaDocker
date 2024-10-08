package com.vicevini.JavaDocker.tarefas;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByUsuario(String usuario, Pageable pageable);

    @Query("from Tarefa t where t.usuario = :usuario")
    List<Tarefa> buscarPorUsuario(String usuario);

    @Query("from Tarefa t where t.usuario = :usuario")
    List<Tarefa> buscarPorUsuarioComParam(@Param("usuario")String usuario);

    List<Tarefa> findByUsuarioAndPrioridade(String usuario, Integer prioridade);

    @Query("from Tarefa t where t.usuario = :usuario and t.prioridade = :prioridade")
    List<Tarefa> buscarPorUsuarioEPrioridade(String usuario);
}