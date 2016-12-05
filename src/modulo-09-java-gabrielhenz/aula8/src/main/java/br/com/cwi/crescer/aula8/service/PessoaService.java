/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel.henz
 */
@Service
public class PessoaService {
    
    private List<Pessoa> pessoas = new ArrayList<>();
    
    public List<Pessoa> listAll() {
        return pessoas;
    }
    
    public List<Pessoa> add(Pessoa p){
        pessoas.add(p);
        return pessoas;
    }
}
