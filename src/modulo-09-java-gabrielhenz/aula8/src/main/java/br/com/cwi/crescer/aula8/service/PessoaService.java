/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel.henz
 */
@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository repository;
    
    public Iterable<Pessoa> findAll() {
        return repository.findAll();
    }
    
    public void save(Pessoa p){
        repository.save(p);
    }
}
