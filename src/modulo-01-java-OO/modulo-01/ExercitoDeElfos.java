import java.util.ArrayList;
public class ExercitoDeElfos extends Exercito
{
    @Override
    public void alistarPersonagem(Personagem personagem){
        if(personagem instanceof ElfoVerde || personagem instanceof ElfoNoturno)
            personagensExercito.add(personagem);
    }
    
    @Override
    public Personagem buscarPorNome(String nome){
        for(Personagem personagem : personagensExercito){
            if(personagem.getNome().equals(nome))
                return personagem;
        }
        return null;
    }
    
    @Override
    public ArrayList<Personagem> buscarPorStatus(Status status){
        ArrayList<Personagem> elfos = new ArrayList<Personagem>();
        for(Personagem personagem : personagensExercito){
            if(personagem.getStatus().equals(status))
                elfos.add(personagem);
        }
        return elfos;
    }
}
