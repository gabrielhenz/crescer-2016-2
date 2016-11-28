/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exemplohibernate.dao;

import java.util.List;

/**
 *
 * @author gabriel.henz
 */
public interface IDao<T, ID> {

    void insert(T t);

    T find(ID id);
    
    void delete(T t);
    
    List<T> findAll();
}
