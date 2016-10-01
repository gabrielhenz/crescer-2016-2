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
