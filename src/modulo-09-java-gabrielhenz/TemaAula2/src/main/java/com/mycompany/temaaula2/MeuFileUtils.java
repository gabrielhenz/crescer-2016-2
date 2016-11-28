/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula2;

import br.com.cwi.crescer.aula1.MeuStringUtil;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class MeuFileUtils {
    
    private String instrucao;
    
    public void setInstrucao(String instrucao){
        boolean instrucaoEhValida = this.validarInstrucao(instrucao);
        if(instrucaoEhValida){
            this.instrucao = instrucao;
        }
    }
    
    public String getInstrucao(){
        return this.instrucao;
    }
    
    public void realizarInstrucao(){
        String instrucao = this.getInstrucao();
        boolean instrucaoEhValida = validarInstrucao(instrucao);
        if(instrucaoEhValida){
            String[]comandos = instrucao.split(" ");
            File file = new File(comandos[1]);
            boolean arquivoExistente = file.exists();
            if(comandos[0].equals("mk")){
                if(!arquivoExistente){
                    try {
                        if(comandos[1].contains(".")){
                            file.createNewFile();
                        } else {
                            file.mkdirs();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("O arquivo/diretorio já existe.");
                }
            }
            
            if(comandos[0].equals("rm")){
                if(arquivoExistente){
                    file.delete();
                } else {
                    System.out.println("O arquivo a ser deletado não existe.");
                }
            }
            
            if(comandos[0].equals("ls")){
                if(verificarSeEhArquivo(comandos[1])){
                    System.out.println(file.getAbsolutePath());
                } else {
                    File[]files = file.listFiles();
                    Arrays.asList(files).forEach(System.out::println);
                }
            }
            
            if(comandos[0].equals("mv")){
                File renamedFile = new File(comandos[2]);
                if(renamedFile.exists()){
                    System.out.println("O nome de arquivo para a renomeação já existe.");
                } else {
                    file.renameTo(renamedFile);
                }
            }
        }  
    }

    private boolean validarInstrucao(String instrucao){
        String comando = instrucao.substring(0, 2);
        if(!comando.equals("mk") && !comando.equals("rm") 
                && !comando.equals("ls") && !comando.equals("mv")){
            System.out.println("O comando é inválido. Tente 'mk', 'rm', 'ls' ou 'mv'.");
            return false;
        } else {
            int indexTxt = instrucao.indexOf(".txt");
            String[]comandos = instrucao.split(" ");
            if(comando.equals("rm") || comando.equals("mk") || comando.equals("ls")){
                if(comandos.length > 2){
                    System.out.println("Você só deve passar um arquivo/diretorio como parametro");
                    return false;
                }
            }
            if(comando.equals("mv")){
                if(comandos.length != 3){
                    System.out.println("Você só deve passar dois arquivo/diretorio como parametro");
                    return false;
                }
            }
            if(comando.equals("rm") || comando.equals("mv")){
                if(!verificarSeEhArquivo(comandos[1])){
                    System.out.println("Arquivo inválido.");
                    return false;
                }
            }    
            if(comando.equals("mv")){
                int indexPontoAtual = comandos[1].indexOf('.');
                int indexPontoNovo = comandos[2].indexOf('.');
                if(indexPontoAtual == -1 || indexPontoNovo == -1){
                    System.out.println("A extensão dos arquivos não é a mesma.");
                    return false;
                }
                String extensaoAtual = comandos[1].substring(indexPontoAtual, comandos[1].length() - 1);
                String extensaoNovo = comandos[2].substring(indexPontoNovo, comandos[2].length() - 1);
                if(!extensaoAtual.equals(extensaoNovo)){
                    System.out.println("A extensão dos arquivos não é a mesma.");
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean verificarSeEhArquivo(String path){
        return new File(path).isFile();
    }
    
}
