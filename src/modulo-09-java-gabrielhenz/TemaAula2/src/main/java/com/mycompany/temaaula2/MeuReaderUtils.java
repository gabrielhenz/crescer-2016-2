/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class MeuReaderUtils {
    public List<String> exibirConteudo(String path){
        if(!path.contains(".txt") || path.isEmpty()){
            System.out.println("O arquivo solicitado é incompatível.");
        } else {
            File file = new File(path);
            if(file.exists() && file.isFile()){
                try 
                (final BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) 
                {
                    List<String> valores = new ArrayList<>();
                    bufferedReader.lines().forEach(l -> valores.add(l));
                    return valores;
                } catch(IOException ex){
                    ex.printStackTrace();
                }
            } else {
                System.out.println("O arquivo não existe.");
            }
        }
        return null;
    }
}
