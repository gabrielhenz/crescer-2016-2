/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author gabriel.henz
 */
public class Exemplo1 {
    public static void main(String[] args) {
        try {
            
            final File file = new File("aula2.txt");
            file.createNewFile();
            if(file.exists()){
                System.out.println(file.getAbsolutePath());
            }
            
            final String path = "C:\\Users\\gabriel.henz\\Desktop\\java";
            
            //imprime os nomes de arquivos desse diretorio
            Arrays.asList(new File(path).list())
                    .forEach(System.out::println);
            
            //imprime os nomes de arquivos desse diretorio que contem a extensao .class
            Arrays.asList(new File(path)
                    .listFiles(f -> f.getName().contains(".class"))
            ).forEach(System.out::println);
            
        } catch (Exception e){ }
    }
}
