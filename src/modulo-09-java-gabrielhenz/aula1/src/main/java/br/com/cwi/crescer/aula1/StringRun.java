package br.com.cwi.crescer.aula1;

/**
 *
 * @author gabriel.henz
 */
import java.util.Scanner;
public class StringRun {
    public static Scanner t = new Scanner(System.in);
     public static void main(String[] args) {
        /*
        "A" == new String("A")
        compara o local de memoria do objeto
        */
        if ("A".compareTo(new String("A")) == 0) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
        
         System.out.println("Digite uma palavra");
         System.out.format("Qtde de vogais: %d", ContaQuantidadeDeVogais(t.nextLine()));
         
         System.out.println("\nDigite uma palavra");
         System.out.format("Palavra invertida: %s", ReverteString(t.nextLine()));
         
         System.out.println("\nDigite uma palavra");
         char[]letras = PalavraParaArrayDeLetras(t.nextLine());
         System.out.format("Array de letras:");
         for(int i = 0; i < letras.length; i++){
             System.out.format("%c, ", letras[i]);
         }
         
    }
     
     private static int ContaQuantidadeDeVogais(final String palavra){
         return palavra.length() - palavra.replaceAll("[aeiouAEIOU]", "").length();
     }
     
     private static String ReverteString(final String palavra){
         return new StringBuilder(palavra).reverse().toString();
     }
     
     private static char[] PalavraParaArrayDeLetras(final String palavra){
         int tamPalavra = palavra.length();
         char[] letras = new char[tamPalavra];
         new StringBuilder(palavra).getChars(0, tamPalavra, letras, 0);
         return letras;
     }
}
