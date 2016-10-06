import java.util.HashMap;
import java.util.ArrayList;
public class ExercitoEspecialDeElfos
{
    private HashMap<String, Elfo> elfosDoExercitoEspecial;
    
    public ExercitoEspecialDeElfos(){
        elfosDoExercitoEspecial = new HashMap<String, Elfo>();
    }
    
    public Elfo[] getExercitoEspecialDeElfos(){
        return elfosDoExercitoEspecial.values().toArray(new Elfo[elfosDoExercitoEspecial.size()]);
    }
    
    public void alistarElfoDoExercitoEspecial(Elfo elfo){
        if(elfo.getClass() == ElfoNoturno.class || elfo.getClass() == ElfoVerde.class)
            elfosDoExercitoEspecial.put(elfo.getNome(), elfo);
    }
    
    public Elfo buscarPorNome(String nome){
        return elfosDoExercitoEspecial.get(nome);
    }
    
    public ArrayList<Elfo> buscarPorStatus(Status status){
        ArrayList<Elfo> elfos = new ArrayList<>();
        for(Elfo elfo : elfosDoExercitoEspecial.values()){
            if(elfo.getStatus().equals(status))
            elfos.add(elfo);
        }
        return elfos;
    }
    
}


