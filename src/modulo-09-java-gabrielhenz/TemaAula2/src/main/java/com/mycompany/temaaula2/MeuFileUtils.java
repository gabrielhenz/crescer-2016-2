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
import java.util.Scanner;
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
            String comando = instrucao.substring(0, 2);
            String path = instrucao.substring(3);
            File file = new File(path);
            boolean arquivoExistente = file.exists();
            if(comando.equals("mk")){
                if(!arquivoExistente){
                    try {
                        boolean ehArquivo = new ValidadorDeExtensao().validar(path);
                        if(ehArquivo){
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
            
            if(comando.equals("rm")){
                if(arquivoExistente){
                    file.delete();
                } else {
                    System.out.println("O arquivo a ser deletado não existe.");
                }
            }
            
            if(comando.equals("ls")){
                if(verificarSeEhArquivo(path)){
                    System.out.println(file.getAbsolutePath());
                } else {
                    File[]files = file.listFiles();
                    Arrays.asList(files)
                            .stream()
                            .map(f -> f.getName())
                            .forEach(System.out::println);
                }
            }
            
            if(comando.equals("mv")){
                Scanner t = new Scanner(System.in);
                System.out.print("Novo nome: ");
                String novoNome = t.nextLine();
                boolean ehArquivo = new ValidadorDeExtensao().validar(novoNome);
                if(!ehArquivo){
                    System.out.println("Arquivo inválido.");
                } else {
                    File novoArquivo = new File(novoNome);
                    if(novoArquivo.exists()){
                        System.out.println("O nome de arquivo para a renomeação já existe.");
                    } else {
                        String extensaoVelho = path.substring(path.lastIndexOf("."));
                        String extensaoNovo = novoNome.substring(novoNome.lastIndexOf("."));
                        if(extensaoVelho.equals(extensaoNovo)){
                            file.renameTo(novoArquivo);
                        } else {
                            System.out.println("A extensão não é a mesma.");
                        }
                    }
                }
            }
        }  
    }

    private boolean validarInstrucao(String instrucao){
        String comando = instrucao.trim().substring(0, 2);
        if(!comando.equals("mk") && !comando.equals("rm") 
                && !comando.equals("ls") && !comando.equals("mv")){
            System.out.println("O comando é inválido. Tente 'mk', 'rm', 'ls' ou 'mv'.");
            return false;
        } else {
            int i = 0;
            String path = instrucao.substring(3).trim();
            if(comando.equals("mv") || comando.equals("rm")){
                boolean instrucaoEhValida = new ValidadorDeExtensao().validar(path);
                if(!instrucaoEhValida){
                    System.out.println("Arquivo inválido.");
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
