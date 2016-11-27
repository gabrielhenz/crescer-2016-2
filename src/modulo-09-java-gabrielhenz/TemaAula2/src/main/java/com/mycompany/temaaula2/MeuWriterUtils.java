/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class MeuWriterUtils {
    public void escreverNoArquivo(String path, List<String> frases){
        if(!path.contains(".txt") || path.isEmpty()){
            System.out.println("O arquivo solicitado é incompatível.");
        } else {
            File file = new File(path);
            if(file.exists() && file.isFile()){
                try 
                (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true)))
                {
                    for(String frase : frases){
                        bufferedWriter.newLine();
                        bufferedWriter.append(frase);
                    }
                    bufferedWriter.flush();
                } catch(IOException ex){
                    ex.printStackTrace();
                }
            } else {
                System.out.println("O arquivo não existe.");
            }
        }
    }
}
