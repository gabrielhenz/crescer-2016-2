/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.filters;

import br.com.cwi.crescer.aula5.utils.UserDetails;

/**
 *
 * @author Gabriel
 */
public class LoggedUser implements UserDetails{

    private String username;
    private String email;
    
    @Override
    public String getUsername() {
        return this.username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String getEmail() {
        return this.email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
