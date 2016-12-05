/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.repository;

/**
 *
 * @author gabriel.henz
 */

import br.com.cwi.crescer.aula8.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}