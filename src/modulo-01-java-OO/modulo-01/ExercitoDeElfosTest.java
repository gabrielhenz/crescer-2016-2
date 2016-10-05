

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ExercitoDeElfosTest
{
    @Test
    public void exercitoCom1Elfo(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistarPersonagem(new Elfo("legolas"));
        assertEquals(0, exercitoDeElfos.getPersonagensExercito().size());
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoE1ElfoVerde(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistarPersonagem(new ElfoVerde("legolas"));
        exercitoDeElfos.alistarPersonagem(new ElfoNoturno("legolas"));
        assertEquals(2, exercitoDeElfos.getPersonagensExercito().size());
    }
    
    @Test
    public void exercitoCom1ElfoVerdeEAtiraFlecha(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistarPersonagem(new ElfoVerde("legolas"));
        ((ElfoVerde)exercitoDeElfos.getPersonagensExercito().get(0)).atirarFlecha(new Dwarf());
        assertEquals(41, exercitoDeElfos.getPersonagensExercito().get(0).getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoE1ElfoVerdeEBuscaNoturnoPorNome(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistarPersonagem(new ElfoVerde("legolas"));
        exercitoDeElfos.alistarPersonagem(new ElfoNoturno("legolasDemonio"));
        assertEquals(new ElfoNoturno("legolasDemonio"), exercitoDeElfos.buscarPorNome("legolasDemonio"));
    }
    
    /*@Test
    public void exercitoCom1ElfoNoturnoMortoE1ElfoVerdeVivo(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistarPersonagem(new ElfoNoturno("legolas"));
        exercitoDeElfos.alistarPersonagem(new ElfoVerde("legolas"));
        Dwarf dwarf = new Dwarf();
        for(int i = 0; i < 100; i++){
            exercitoDeElfos.getPersonagensExercito().get(0).atirarFlecha(dwarf);
        }
        assertEquals(new ElfoVerde("legolas"), exercitoDeElfos.buscarPorStatus(Status.MORTO).get(0));
    }*/
}
