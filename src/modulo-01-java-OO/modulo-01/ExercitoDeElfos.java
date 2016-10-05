import java.util.ArrayList;
public class ExercitoDeElfos 
{
    {
        elfosExercito = new ArrayList<Elfo>();
    }
    
    private ArrayList<Elfo> elfosExercito;
    
    public ArrayList<Elfo> getElfosExercito(){
        return elfosExercito;
    }
    
    public void alistarElfo(Elfo elfo){
        /*
         * String nomeClasse = elfo.getClass().getName();
         * if(nomeClasse.equals("ElfoVerde" || nomeClasse.equals("ElfoNoturno"))
         * 
         * if(elfo.getClass() == ElfoNoturno.class || elfo.getClass() == ElfoVerde.class)
         */
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            elfosExercito.add(elfo);
    }
    
    public Elfo buscarPorNome(String nome){
        for(Elfo elfo : elfosExercito){
            if(elfo.getNome().equals(nome))
                return elfo;
        }
        return null;
    }
    
    public ArrayList<Elfo> buscarPorStatus(Status status){
        ArrayList<Elfo> elfos = new ArrayList<Elfo>();
        for(Elfo elfo : elfosExercito){
            if(elfo.status.equals(status)){
                elfos.add(elfo);
            }
        }
        return elfos;
    }
}
