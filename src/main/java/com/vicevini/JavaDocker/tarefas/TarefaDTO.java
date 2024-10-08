package com.vicevini.JavaDocker.tarefas;

import javax.validation.constraints.*;

public class TarefaDTO {
    private Long id;

    @NotNull(message = "O campo Título não pode ser nulo.")
    @Size(message = "O campo Título deve possuir de 5 a 100 caracteres", min = 5, max = 100)
    private String titulo;

    @NotNull(message = "O campo Descrição não pode ser nulo.")
    @NotEmpty
    private String descricao;

    @Min(message = "O valor minímo é 1", value = 1)
    @Max(message = "O valor máximo é 5", value = 5)
    @NotNull(message = "O campo Prioridade não pode ser nulo.")
    private Integer prioridade;

    @NotNull(message = "O campo Usuario não pode ser nulo.")
    private String usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}