

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoDeElfosTest {
    
    @After
    // executa após cada cenário de testes.
    public void tearDown() {
        System.gc();
    }
    
    @Test (expected=NaoPodeAlistarException.class)
    public void exercitoCom1Elfo() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistar(new Elfo("legolas"));
        assertEquals(0, exercitoDeElfos.getContingente().length);
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoE1ElfoVerde() throws NaoPodeAlistarException{
        try{
            ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
            exercitoDeElfos.alistar(new ElfoVerde("legolas"));
            exercitoDeElfos.alistar(new ElfoNoturno("legolas"));
            assertEquals(2, exercitoDeElfos.getContingente().length);
        }catch(NaoPodeAlistarException naoPodeAlistarException){
            System.out.println(
                naoPodeAlistarException.getMessage() +
                naoPodeAlistarException.getStackTrace()
            );
        } 
    }
    
    @Test
    public void exercitoCom1ElfoVerdeEAtiraFlecha() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("legolas");
        exercitoDeElfos.alistar(elfoVerde);
        elfoVerde.atirarFlecha(new Dwarf());
        assertEquals(41, exercitoDeElfos.getContingente()[0].getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoE1ElfoVerdeEBuscaNoturnoPorNome () throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        exercitoDeElfos.alistar(new ElfoVerde("legolas"));
        exercitoDeElfos.alistar(new ElfoNoturno("legolasDemonio"));
        assertEquals(new ElfoNoturno("legolasDemonio"), exercitoDeElfos.buscar("legolasDemonio"));
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoMortoE1ElfoVerdeVivo()throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("legolasDemonio", 100);
        exercitoDeElfos.alistar(elfoNoturno);
        exercitoDeElfos.alistar(new ElfoVerde("legolas"));
        for(int i = 0; i < 100; i++){
            elfoNoturno.atirarFlecha(new Dwarf());
        }
        assertTrue(exercitoDeElfos.buscar(Status.MORTO).contains(elfoNoturno));
    }
}
