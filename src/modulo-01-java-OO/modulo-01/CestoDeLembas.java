
/**
 * Escreva a descrição da classe CestoDeLembas aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CestoDeLembas
{
   private int quantidade;
   
   public boolean divisao(){
       boolean ehDivisivel;
       if(quantidade <= 100 && quantidade >= 1){
           ehDivisivel = ((quantidade / 2) % 2 == 0)?true:false;
        }else{
            ehDivisivel = false;
        }
        return ehDivisivel;
    }
}
