/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author gabriel.henz
 */
public class ExemploWriter {

    public static void main(String[] args) {
        try (
            //se colocar true ele appenda no final
            // se nao colocar true ele reescreve tudo
            final Writer writer = new FileWriter("aula2.txt", true);
            final BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ) 
        {
            bufferedWriter.newLine();
            bufferedWriter.append("blablabla");
            bufferedWriter.newLine();
            bufferedWriter.append("kakaka");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
