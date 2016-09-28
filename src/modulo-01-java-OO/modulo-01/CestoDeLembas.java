
/**
 * Escreva a descrição da classe CestoDeLembas aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CestoDeLembas
{
   private int quantidade;
   
   public CestoDeLembas(int q){
       quantidade = q;
    }
    
   public int getQuantidade(){
       return quantidade;
    }
    
   public boolean podeDividirEmPares(){
       return quantidade > 2 && quantidade <= 100 && quantidade % 2 == 0;
    }
}
