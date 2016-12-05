/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabriel.henz
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaRest {

    @Autowired
    private PessoaService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Pessoa> list() {
        return service.listAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public List<Pessoa> add(@RequestBody Pessoa p){
        if(p == null){
            return new ArrayList<Pessoa>();
        }
        p.setData(new Date());
        return service.add(p);
    }
}
