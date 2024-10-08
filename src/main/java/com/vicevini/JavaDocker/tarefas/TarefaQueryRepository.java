package com.vicevini.JavaDocker.tarefas;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TarefaQueryRepository {
    @PersistenceContext

    private EntityManager em;

    public List<Tarefa> customQuery (Integer prioridade, String usuario, Pageable pageable){
        StringBuilder query = new StringBuilder( "from Tarefa t where t.prioridade = :prioridade");
        if(usuario !=null){
            query.append(" and t.usuario = :usuario");
        }

        query.append(" order by t.prioridade ASC");

        TypedQuery<Tarefa> typedQuery = em.createQuery(query.toString(), Tarefa.class);
        typedQuery.setParameter("prioridade", prioridade);
        if(usuario !=null){
            typedQuery.setParameter("usuario", usuario);
        }

        typedQuery.setMaxResults(pageable.getPageSize());
        typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());

        return typedQuery.getResultList();
    }
}
