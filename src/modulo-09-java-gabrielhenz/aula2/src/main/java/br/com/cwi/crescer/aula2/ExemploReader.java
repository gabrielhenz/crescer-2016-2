/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author gabriel.henz
 */
public class ExemploReader {
    public static void main(String[] args) throws IOException {
        try (final Reader reader = new FileReader("aula2.txt");
            final BufferedReader bufferReader = new BufferedReader(reader);)
        {
             bufferReader.lines().forEach(System.out::println);
            
            /*
            final Reader reader = new FileReader("aula2.txt");
            final BufferedReader bufferReader = new BufferedReader(reader);
            
            try {
                bufferReader.lines().forEach(System.out::println);
            } catch(Exception e){
                e.printStackTrace();
            } finally {
                reader.close();
            }
            */
            
            
        } catch(FileNotFoundException e) { 
            e.printStackTrace();
        }
    }
}
