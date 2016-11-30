/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula3;

import java.io.File;
import java.util.List;
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
            System.out.println("3 - Exportar arquivo '.csv'.");
            System.out.println("4 - Importar arquivo '.csv'.");
            System.out.println("5 - Sair.");
            System.out.print("\nDigite a sua opção: ");
            int opcao = t.nextInt();
            while(opcao < 1 && opcao > 5){
                System.out.print("\nOpção inválida, digite outra: ");
                opcao = t.nextInt();
            }
            String path, tabela;
            switch(opcao){
                case 1:
                    System.out.print("\nDigite o caminho do arquivo '.sql': ");
                    t.nextLine();
                    path = t.nextLine();
                    File file = new File(path);
                    if(path.contains(".sql") && file.isFile()){
                        msu.executarInstrucoes(path);
                    } else {
                        System.out.println("O arquivo é inválido.");
                    }
                    break;
                case 2:
                    System.out.print("\nDigite um código SQL: ");
                    t.nextLine();
                    String query = t.nextLine();
                    List<String> valores = msu.executarQuery(query);
                    if(valores != null){
                        for(String valor : valores){
                            System.out.println(valor);
                        }
                    } else { 
                        System.out.println("Ocorreu algum erro ou não existem valores inseridos na tabela.");
                    }
                    break;
                case 3:
                    System.out.print("\nDigite o nome do arquivo: ");
                    t.nextLine();
                    path = t.nextLine();
                    System.out.print("\nDigite o nome da tabela a ser exportada para o arquivo: ");
                    tabela = t.nextLine();
                    msu.exportarCsv(tabela, path);
                    break;
                case 4:
                    System.out.print("\nDigite o nome do arquivo: ");
                    t.nextLine();
                    path = t.nextLine();
                    System.out.print("\nDigite o nome da tabela para o arquivo ser importado: ");
                    tabela = t.nextLine();
                    msu.importarCsv(tabela, path);
                    break;
                default:
                    queroSair = true;
                    break;
            }
        }
    }
}
