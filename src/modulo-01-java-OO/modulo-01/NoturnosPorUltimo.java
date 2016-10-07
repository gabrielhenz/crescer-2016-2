import java.util.List;
import java.util.ArrayList;

public class NoturnosPorUltimo implements Estrategia
{
    
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) {
        
        if(atacantes.size()>0){
            List<Elfo> elfosOrdenados = new ArrayList<>();
            Elfo elfo;
            for(int i = 0; i < atacantes.size(); i++){
                for(int j = 0; j < atacantes.size() - 1; j++){
                    elfo = atacantes.get(j);
                    if(elfo.getClass() == ElfoNoturno.class && elfo.getStatus().equals(Status.VIVO)){
                        atacantes.set(j, atacantes.get(j+1));
                        atacantes.set(j+1, elfo);
                    }
                }
            }
            return atacantes;
        }
        return null;
    }
}
