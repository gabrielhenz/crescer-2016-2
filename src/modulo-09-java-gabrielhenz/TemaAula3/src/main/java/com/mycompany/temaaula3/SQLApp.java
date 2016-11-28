/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula3;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author gabriel.henz
 */
public class SQLApp {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        MeuSQLUtils msu = new MeuSQLUtils();
        boolean queroSair = false;
        while(!queroSair){
            System.out.println("---- MENU ----");
            System.out.println("1 - Executar arquivo '.sql'.");
            System.out.println("2 - Executar código SQL.");
            System.out.println("3 - Sair.");
            System.out.print("\nDigite a sua opção: ");
            int opcao = t.nextInt();
            while(opcao != 1 && opcao != 2 && opcao != 3){
                System.out.print("\nOpção inválida, digite outra: ");
                opcao = t.nextInt();
            }
            switch(opcao){
                case 1:
                    System.out.print("\n\nDigite o caminho do arquivo '.sql': ");
                    String path = t.nextLine();
                    File file = new File(path);
                    if(path.contains(".sql") && file.isFile()){
                        msu.executarInstrucoes(path);
                    } else {
                        System.out.println("O arquivo é inválido.");
                    }
                    break;
                case 2:
                    System.out.print("\n\nDigite um código SQL: ");
                    String codigo = t.nextLine();
                    msu.
            }
            if(msu.getInstrucao() != null){
                msu.realizarInstrucao();
            }
        }
    }
}
