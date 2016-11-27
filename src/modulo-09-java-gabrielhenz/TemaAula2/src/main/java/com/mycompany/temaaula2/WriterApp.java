/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class WriterApp {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        MeuWriterUtils mwu = new MeuWriterUtils();
        System.out.println("Digite 'exit' em qualquer momento para sair do programa.");
        System.out.println("Somente são aceitos arquivos '.txt'.");
        while(true){
            System.out.print("Digite um arquivo: ");
            String path = t.nextLine();
            if(!path.contains(".txt") || path.isEmpty()){
                System.out.println("O arquivo solicitado é incompatível.");
            } 
            if(path.equals("exit")){
                System.out.println("saindo...");
                break;
            }
            System.out.println("Digite 'stop' em qualquer momento para parar de digitar frases.");
            System.out.println("Digite as frases (pressionar enter para uma nova frase):");
            List<String> frases = new ArrayList<>();
            while(true){
                String frase = t.nextLine();
                if(frase.equals("stop")){
                    System.out.println("parando...");
                    break;
                } else {
                    frases.add(frase);
                }
            }
            mwu.escreverNoArquivo(path, frases);
        }
    }
}
