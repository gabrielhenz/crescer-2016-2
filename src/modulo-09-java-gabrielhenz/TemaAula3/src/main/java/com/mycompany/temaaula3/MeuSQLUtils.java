/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class MeuSQLUtils {

    public void executarInstrucoes(String path) {
        if (!path.contains(".sql") || path.isEmpty()) {
            System.out.println("O arquivo solicitado é incompatível. Precisa possuir extensão '.sql'.");
        } else {
            File file = new File(path);
            String s;
            StringBuffer sb = new StringBuffer();
            if (file.exists() && file.isFile()) {
                try (
                        FileReader fr = new FileReader(file);
                        final BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
                    while ((s = bufferedReader.readLine()) != null) {
                        sb.append(s);
                    }
                    String[] comandos = sb.toString().split(";");
                    for (String comando : comandos) {
                        String tipoDeComando = comando.split(" ")[0];
                        if (tipoDeComando.trim().compareToIgnoreCase("SELECT") == 0) {
                            executarQuery(comando);
                        } else {
                            executarStatement(comando);
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("O arquivo não existe.");
            }
        }
    }
    
    public void exportarCsv(String path){
        if (!path.contains(".csv") || path.isEmpty()) {
            System.out.println("O arquivo solicitado é incompatível. Precisa possuir extensão '.sql'.");
        }
    }
    
    public void importarCsv(){
        
    }
    
    private void executarQuery(String query){
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query);) {
            ResultSetMetaData meta = resultSet.getMetaData();
            int qtdeColunas = meta.getColumnCount();
            boolean naoPassou = true;
            int linha = 1;
            while (resultSet.next()) {
                for(int i = 1; i <= qtdeColunas; i++){
                    if(naoPassou){
                        String nomeColuna = "  " + meta.getColumnName(i);
                        int qtdeDeCaracteres = 
                                meta.getColumnDisplaySize(i) - nomeColuna.length();
                        for(int j = 0; i < qtdeDeCaracteres; i++){
                            nomeColuna += " ";
                        }
                        System.out.print(nomeColuna);
                    }
                }
                naoPassou = false;
                 for(int i = 1; i <= qtdeColunas; i++){
                    if(naoPassou){
                        String valorColuna = linha + " " + resultSet.getObject(i).toString();
                        int qtdeDeCaracteres = 
                                meta.getColumnDisplaySize(i) - valorColuna.length();
                        for(int j = 0; i < qtdeDeCaracteres; i++){
                            valorColuna += " ";
                        }
                        System.out.print(valorColuna);
                    }
                }
                linha++;
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    private void executarStatement(String comando) {
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(comando);
            ) {
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
