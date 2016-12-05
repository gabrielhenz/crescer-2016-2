/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

/**
 *
 * @author gabriel.henz
 */
import br.com.cwi.crescer.aula8.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class Exemplo {

    @Autowired PessoaService pessoaService;
    
    @RequestMapping(method = RequestMethod.GET)
    String toIndex(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name == null ? "Gabriel Dias Henz" : name);
        model.addAttribute("pessoas", pessoaService.findAll());
        return "index";
    }

}
