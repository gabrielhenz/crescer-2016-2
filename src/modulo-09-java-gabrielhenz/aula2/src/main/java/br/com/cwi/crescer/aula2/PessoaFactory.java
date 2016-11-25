/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import oracle.net.aso.p;

/**
 *
 * @author gabriel.henz
 */
public class PessoaFactory {

    public void create() {
        final String ddl = "CREATE TABLE HENZ ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            statement.executeUpdate(ddl);
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public void insert(Pessoa p) {
        final String insert = "INSERT INTO HENZ("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES (?, ?)";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(insert);
            ) {
                preparedStatement.setLong(1, p.getIdPessoa());
                preparedStatement.setString(2, p.getNmPessoa());
                preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    
     public void delete(Pessoa p) {
        final String delete = "DELETE HENZ WHERE ID_PESSOA = ?";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(delete);
            ) {
                preparedStatement.setLong(1, p.getIdPessoa());
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
     /*
      public List<Pessoa> findAll() {
        final String query = "SELECT * FROM CARLOS";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement(query);
                
            ) {
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }*/
    
    public static void main(String[] args) {
        final PessoaFactory pessoaFactory = new PessoaFactory();
        
        Pessoa p = new Pessoa();
        p.setIdPessoa(1l);
        p.setNmPessoa("Gabriel");
        
        pessoaFactory.insert(p);
        //pessoaFactory.delete(p);
        
        for(int i = 1; i <= 10; i++){
            final Pessoa pessoa = new Pessoa();
            pessoa.setIdPessoa(Long.valueOf(i));
            pessoa.setNmPessoa("PESSOA " + i);
            pessoaFactory.insert(pessoa);
        }
        
        /*
        pessoaFactory
                .findAll()
                .forEach(p -> {
                    System.out.println("{'idPessoa':'%s', 'nmPessoa':'%s'\n", p.getIdPessoa(), p.getNmPessoa())
                });
    }*/
    }
}
