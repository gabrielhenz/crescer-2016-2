/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaaula5.beans;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface IBean<T> {

    void insert(T t);

    void delete(T t);
    
    void update(T t);

    T find(Long id);

    List<T> findAll();
}
