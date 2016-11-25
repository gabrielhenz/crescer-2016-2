/*
Criar uma classe MeuStringUtil que tenha as definições abaixo.

Deve possuir um metodo que valide se String é vazia.
Deve possuir um metodo que conte o nº de vogais da String (a,e,i,o,u).
Deve possuir um metodo que inverta uma String.
Deve possuir um metodo que identifique um palíndromo.("ovo", "Ame a ema", "A sogra má e amargosa")
Criar um metodo main, que informe os recursos disponíveis ao usuário.
*/
package br.com.cwi.crescer.aula1;

import java.text.Collator;
import java.util.Scanner;

/**
 *
 * @author gabriel.henz
 */
public class MeuStringUtil {
    static Scanner t = new Scanner(System.in);
    
    public static void main(String[]args){
        boolean sair = false;
        while(!sair){
            System.out.println("-----MENU DE OPÇÕES-----"
                + "\n\n1 - Valida se o texto digitado é uma string vazia."
                + "\n2 - Conta a quantidade de vogais do texto digitado."
                + "\n3 - Inverte o texto digitado."
                + "\n4 - Verifica se o texto digitado é um palíndromo."
                + "\n5 - Sair.");
        System.out.print("\nDigite o número da sua opção: ");
        int opcao = t.nextInt();
        while(opcao < 1 || opcao > 5){
            System.out.print("\n\nOpção inválida.\nTente novamente: ");
            opcao = t.nextInt();
        }
        sair = escolherOpcao(opcao);
        }   
    }
    
    static boolean escolherOpcao(int opcao){
        MeuStringUtil self = new MeuStringUtil();
        switch(opcao){
            case 1:
                System.out.print("Digite um texto: ");
                System.out.println(
                        self.validarStringVazia(t.nextLine()) 
                                ? "O texto é uma string vazia"
                                : "O texto não é uma string vazia");
                break;
            case 2:
                System.out.print("Digite um texto: ");
                System.out.format("Número de vogais no texto: %d", 
                        self.contaQuantidadeDeVogais(t.nextLine()));
                break;
            case 3:
                System.out.print("Digite um texto: ");
                System.out.format("Texto invertido: %s", 
                        self.inverterTexto(t.nextLine()));
            case 4:
                System.out.print("Digite um texto: ");
                System.out.println(
                        self.verificaPalindromo(t.nextLine()) 
                                ? "O texto é um palíndromo"
                                : "O texto não é um palíndromo");
            default:
                return true;
        }
        return false;
    }
    
    public boolean validarStringVazia(String texto){
        return texto.length() == 0;
    }
    
    public int contaQuantidadeDeVogais(String texto){
        return texto.length() - texto.replaceAll("[aeiouAEIOU]", "").length();
    }
    
    public String inverterTexto(String texto){
        return new StringBuilder(texto).reverse().toString();
    }
    
    public boolean verificaPalindromo(String texto){
        final Collator instance = Collator.getInstance();
        instance.setStrength(Collator.NO_DECOMPOSITION);
        return instance.compare(texto.toLowerCase().replaceAll("\\s", ""), 
                inverterTexto(texto).toLowerCase().replaceAll("\\s", "")) == 0;
    }
}
