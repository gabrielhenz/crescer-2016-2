import java.util.*;

public class AtaqueIntercalado implements EstrategiaAtaqueIntercalado
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ContemElfoNormalException, ContingenteDesproporcionalException{
            if(contemElfoNormal(atacantes)){
                throw new ContemElfoNormalException();
            }
            
            if(atacantes.size() <= 0){
                return null;
            }
            if(contingenteEhProporcinal(atacantes)){               
                atacantes = ordenaLista(atacantes);
                return atacantes;
            }else{
                throw new ContingenteDesproporcionalException();
            }
   }
   
   private boolean contingenteEhProporcinal(List<Elfo> atacantes){
       int countElfosVerdes = 0, countElfosNoturnos = 0;
       for(Elfo elfo : atacantes){
           if(elfo.getStatus().equals(Status.VIVO)){
               if(elfo instanceof ElfoVerde)
               countElfosVerdes++;
               else
               countElfosNoturnos++;
           }
        }
        return countElfosVerdes == countElfosNoturnos;
   }
   
   private boolean contemElfoNormal(List<Elfo> atacantes)throws ContemElfoNormalException{
       for(Elfo elfo : atacantes){
            if(elfo.getClass().getName().equals("Elfo"))
                return true;
        }
        return false;
    }
    
    private List<Elfo> ordenaLista(List<Elfo> atacantes){
        Elfo elfoIteracao;
        Class classe1, classe2;
        if(atacantes.get(0) instanceof ElfoVerde){
            classe1 = ElfoVerde.class;
            classe2 = ElfoNoturno.class;
        }else{
            classe1 = ElfoNoturno.class;
            classe2 = ElfoVerde.class;
        }
        for(int i = 1; i < atacantes.size(); i++){
            for(int j = i; j < atacantes.size(); j++){
                elfoIteracao = atacantes.get(j);
                if(elfoIteracao.getClass() == classe1 && i % 2 == 0){
                    atacantes = trocaPosicao(atacantes, elfoIteracao, i, j);
                    break;
                }
                if(elfoIteracao.getClass() == classe2 && i % 2 != 0){
                    atacantes = trocaPosicao(atacantes, elfoIteracao, i, j);
                    break;
                }
            }
        }
        return atacantes;
    }
    
    private List<Elfo> trocaPosicao(List<Elfo> atacantes, Elfo elfoIteracao, int i, int j){
        Elfo temp = atacantes.get(i);
        atacantes.set(i, elfoIteracao);
        atacantes.set(j, temp);
        return atacantes;
    }
}
