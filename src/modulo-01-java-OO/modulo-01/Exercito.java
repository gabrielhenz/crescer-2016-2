import java.util.ArrayList;
public abstract class Exercito
{
    protected ArrayList<Personagem> personagensExercito;
    
    public Exercito(){
        personagensExercito = new ArrayList<Personagem>();
    }
    
    abstract void alistarPersonagem(Personagem personagem);
    
    public ArrayList<Personagem> getPersonagensExercito(){
        return personagensExercito;
    }
    
    abstract Personagem buscarPorNome(String nome);
    
    abstract ArrayList<Personagem> buscarPorStatus(Status status);
}
