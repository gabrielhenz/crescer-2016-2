import java.util.ArrayList;
public class HobbitContador
{
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDeArrayDePares){
        int diferenca, soma = 0, numero1, numero2;
        for(ArrayList<Integer> arrayDePares : arrayDeArrayDePares){
            numero1 = arrayDePares.get(0);
            numero2 = arrayDePares.get(1);
            soma += ((numero1 * numero2) - calcularMmc(numero1, numero2));
        }
        return soma;
    }
    
    public int calcularMmc(int numero1, int numero2) {
        int n = 2, resultado = 1;
        while (numero1 != 1 ||  numero2 != 1) {
            while (numero1 %  n != 0 &&  numero2 %  n != 0) {
                 n++;
            }
            if (numero1 % n == 0) {
                 numero1 =  numero1 / n;
            }
            if (numero2 % n == 0) {
                 numero2 =  numero2 / n;
            }
             resultado *=  n;
        }
        return  resultado;
    }

}
/*
import java.util.*;

public class HobbitContador {
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> pares) {
        int somaProdutos = 0, somaMmc = 0;

        for (ArrayList<Integer> par : pares) {
            int a = par.get(0), b = par.get(1);
            somaProdutos += a * b;
            somaMmc += new CalculadorMmc(a, b).calcular();
        }
        
        // Fluent APIs
        // crieUmHobbit().depoisCalculeMmc().depoisEnviePorEmail();

        return somaProdutos - somaMmc;
    }

    private class CalculadorMmc {
        private int a, b, mdc;
        private CalculadorMmc(int a, int b) {
            this.a = a;
            this.b = b;
            this.mdc = mdc(a, b);
        }

        // https://en.wikipedia.org/wiki/Least_common_multiple
        private int calcular() {
            boolean temZero = a == 0 || b == 0;
            return temZero ? 0 : a * b / mdc;
        }

        // https://en.wikipedia.org/wiki/Greatest_common_divisor
        private int mdc(int a, int b) {
            while (b != 0) {
                int troca = b;
                b = a % b;
                a = troca;
            }
            return a;
        }
    }
}
*/