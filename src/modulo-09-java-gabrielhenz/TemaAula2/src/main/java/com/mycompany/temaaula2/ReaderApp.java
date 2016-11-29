/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula2;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class ReaderApp {
     public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        MeuReaderUtils mru = new MeuReaderUtils();
        System.out.println("Digite 'exit' para sair do programa.");
        System.out.println("Somente são aceitos arquivos '.txt'.");
        while(true){
            System.out.print("Digite um arquivo: ");
            String comando = t.nextLine();
            if(comando.equals("exit")){
                System.out.println("saindo...");
                break;
            }
            List<String> valores = mru.exibirConteudo(comando);
            for(String valor : valores){
                System.out.println(valor);
            }
        }
    }
}
