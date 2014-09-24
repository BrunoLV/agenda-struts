package com.valhala.agenda.persistencia.dao;

import java.util.List;

public interface BaseDao<T> {

    void inserir(T t);

    void atualizar(T t);

    void remover(Integer id);

    T buscarPorId(Integer id);

    List<T> buscarTodos();

}
