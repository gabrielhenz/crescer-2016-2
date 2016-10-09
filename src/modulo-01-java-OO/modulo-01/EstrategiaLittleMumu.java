import java.util.*;

public class EstrategiaLittleMumu implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ContemElfoNormalException{
        if(atacantes.size() > 0){
            for(Elfo elfo : atacantes){
                if(elfo.getClass().getName().toString().equals("Elfo"))
                    throw new ContemElfoNormalException();
            }
            
            atacantes.removeIf(elfo -> elfo.getStatus().equals(Status.MORTO) || elfo.getInventario().getItens().get(1).getQuantidade() <= 0);
            int elfosAptos = atacantes.size();
            int qtdePossivelDeElfosNoturnos = (int)(elfosAptos * 0.3);
            int countQtdeDeElfosNoturnos = 0;
            for(Elfo elfo : atacantes){
                if(elfo instanceof ElfoNoturno){
                    countQtdeDeElfosNoturnos++;
                }
            }
            if(countQtdeDeElfosNoturnos > qtdePossivelDeElfosNoturnos){
                int qtdeDeElfosNoturnosASeremRemovidos = Math.abs(countQtdeDeElfosNoturnos - qtdePossivelDeElfosNoturnos);
                atacantes.removeAll(elfosASeremRemovidos(atacantes, qtdeDeElfosNoturnosASeremRemovidos));
            }
            atacantes = ordenarPorQuantidadeDeFlechas(atacantes);
        }else{
            atacantes = null;
        }
        return atacantes;
    }
    
    public List<Elfo> elfosASeremRemovidos(List<Elfo> atacantes, int qtdeDeElfosNoturnosASeremRemovidos){
        List<Elfo> elfosASeremRemovidos = new ArrayList<>();
        int countElfosNoturnosRemovidos = 0;
        Elfo elfo;
        for(int i = atacantes.size() - 1; i >= 0; i--){
            elfo = atacantes.get(i);
            if(elfo instanceof ElfoNoturno){
                elfosASeremRemovidos.add(elfo);
                countElfosNoturnosRemovidos++;
            }
            if(countElfosNoturnosRemovidos == qtdeDeElfosNoturnosASeremRemovidos){
                break;
            }
        }
        return elfosASeremRemovidos;
    }
    
    private List<Elfo> ordenarPorQuantidadeDeFlechas(List<Elfo> atacantes){
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < atacantes.size() - 1; j++) {
                Elfo elfoAtual = atacantes.get(j);
                Elfo proximo = atacantes.get(j + 1);

                boolean precisaTrocar = 
                    elfoAtual.getInventario().getItens().get(1).getQuantidade()
                    >
                    proximo.getInventario().getItens().get(1).getQuantidade();

                if (precisaTrocar) {
                    atacantes.set(j, proximo);
                    atacantes.set(j + 1, elfoAtual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
        return atacantes;
    }
}
