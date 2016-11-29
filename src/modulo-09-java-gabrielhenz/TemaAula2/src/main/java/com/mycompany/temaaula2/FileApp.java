/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula2;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class FileApp {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        MeuFileUtils mfu = new MeuFileUtils();
        System.out.println("-- COMANDOS --");
        System.out.println("Digite 'exit' para sair do programa.");
        System.out.println("Digite 'mk ' seguido do nome do arquivo/diretorio.");
        System.out.println("Digite 'ls ' seguido do nome do arquivo/diretorio.");
        System.out.println("Digite 'rm ' seguido do nome do arquivo.");
        System.out.println("Digite 'mv ' seguido do nome do arquivo e pressione Enter.");
        System.out.println("Em seguida digite o novo nome do arquivo com a sua extensão.");
        System.out.println("\n\n");
        while(true){
            System.out.print("Digite um comando: ");
            String comando = t.nextLine();
            if(comando.equals("exit")){
                System.out.println("saindo...");
                break;
            }
            mfu.setInstrucao(comando);
            if(mfu.getInstrucao() != null){
                mfu.realizarInstrucao();
            }
        }
    }
}
