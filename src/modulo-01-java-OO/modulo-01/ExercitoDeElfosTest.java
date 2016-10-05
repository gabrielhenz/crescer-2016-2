

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ExercitoDeElfosTest
{
    @Test
    public void exercitoCom1Elfo(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistarElfo(new Elfo("legolas"));
        assertEquals(0, exercitoDeElfos.getElfosExercito().size());
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoE1ElfoVerde(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistarElfo(new ElfoVerde("legolas"));
        exercitoDeElfos.alistarElfo(new ElfoNoturno("legolas"));
        assertEquals(2, exercitoDeElfos.getElfosExercito().size());
    }
    
    @Test
    public void exercitoCom1ElfoVerdeEAtiraFlecha(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistarElfo(new ElfoVerde("legolas"));
        exercitoDeElfos.getElfosExercito().get(0).atirarFlecha(new Dwarf());
        assertEquals(41, exercitoDeElfos.getElfosExercito().get(0).getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoE1ElfoVerdeEBuscaNoturnoPorNome(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistarElfo(new ElfoVerde("legolas"));
        exercitoDeElfos.alistarElfo(new ElfoNoturno("legolasDemonio"));
        assertEquals(new ElfoNoturno("legolasDemonio"), exercitoDeElfos.buscarPorNome("legolasDemonio"));
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoMortoE1ElfoVerdeVivo(){
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("legolasDemonio", 100);
        exercitoDeElfos.alistarElfo(elfoNoturno);
        exercitoDeElfos.alistarElfo(new ElfoVerde("legolas"));
        for(int i = 0; i < 100; i++){
            exercitoDeElfos.getElfosExercito().get(0).atirarFlecha(new Dwarf());
        }
        assertTrue(exercitoDeElfos.buscarPorStatus(Status.MORTO).contains(elfoNoturno));
    }
}
