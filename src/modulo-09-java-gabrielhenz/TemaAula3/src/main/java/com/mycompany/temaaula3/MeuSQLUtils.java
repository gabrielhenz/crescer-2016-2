/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula3;

import com.mycompany.temaaula2.MeuReaderUtils;
import com.mycompany.temaaula2.MeuWriterUtils;
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
        path = path.trim();
        if (!path.substring(path.lastIndexOf(".")).equals(".sql") || path.isEmpty()) {
            System.out.println("O arquivo solicitado é incompatível. Precisa possuir extensão '.sql'.");
        } else {
            File file = new File(path);
            String s;
            StringBuffer sb = new StringBuffer();
            if (file.exists() && file.isFile()) {
                try (FileReader fr = new FileReader(file);
                     final BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) 
                {
                    while ((s = bufferedReader.readLine()) != null) {
                        sb.append(s.trim());
                    }
                    String[] comandos = sb.toString().split(";");
                    for (String comando : comandos) {
                        String tipoDeComando = comando.split(" ")[0];
                        if (tipoDeComando.compareToIgnoreCase("SELECT") == 0) {
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
    
    public void exportarCsv(String tabela, String path){
        if (!path.contains(".csv") || path.isEmpty()) {
            System.out.println("O arquivo solicitado é incompatível. Precisa possuir extensão '.csv'.");
        } else {
            try{
                File file = new File(path);
                if(!file.exists()){
                    file.createNewFile();
                } else {
                    file.delete();
                    file.createNewFile();
                }
                List<String> valores = executarQuery(
                        String.format(
                        "SELECT /*csv*/ %s FROM %s;", 
                        tabela.substring(0, 1), tabela));
                if(valores != null){
                    MeuWriterUtils mwu = new MeuWriterUtils();
                    mwu.escreverNoArquivo(path, valores);
                }
            } catch(IOException e){
                e.printStackTrace();
            }     
        }
    }
    
    public void importarCsv(String tabela, String path){
        File file = new File(path);
        if(!file.exists() || !path.contains(".sql")){
            System.out.println("Arquivo inválido.");
        } else {
            MeuReaderUtils mru = new MeuReaderUtils();
            List<String> valores = mru.exibirConteudo(path);
            if(valores != null){
                List<String> colunasValores = getValoresColunas(valores);
                String colunasNomes = colunasValores.get(0).replaceAll("\"", "");
                String query = String.format("INSERT INTO %s(%s) VALUES", tabela, colunasNomes);
                for(int i = 1; i < colunasValores.size(); i++){
                    query += String.format(" (%s),", colunasValores.get(i));
                }
                query = query.substring(0, query.lastIndexOf(",") - 1);
                query += ";";
                query = query.replaceAll("\"", "'");
                executarStatement(query);
            } else {
                System.out.println("Ocorreu algum erro.");
            }
        }
    }
    
    private List<String> getValoresColunas(List<String> valores){
        List<String> colunasValores = new ArrayList<>();
        for(String valor : valores){
            valor = valor.substring(2);
            String colunaNome = "";
            String[]nomeColunaValor = valor.split(";");
            for(int i = 0; i < nomeColunaValor.length; i++){
                colunaNome += "'"+nomeColunaValor[i].split(":")[1] + "',";
            }
            colunasValores.add(colunaNome.substring(0, colunaNome.lastIndexOf(",") - 1));
        }
        return colunasValores;
    }
    
    public List<String> executarQuery(String query){
        List<String> valores = new ArrayList<>();
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query);) {
            ResultSetMetaData meta = resultSet.getMetaData();
            int qtdeColunas = meta.getColumnCount();
            boolean naoPassou = true;
            int linha = 1;
            String imprimir = "";
            while (resultSet.next()) {
                imprimir = linha + " ";
                for(int i = 1; i <= qtdeColunas; i++){
                        imprimir +=  meta.getColumnName(i) + ":" + resultSet.getObject(i).toString() + ";";
                }
                imprimir = imprimir.substring(0, imprimir.length() - 2);
                valores.add(imprimir);
                linha++;
            }
            return valores;
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return null;
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
