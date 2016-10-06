

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoEspecialDeElfosTest
{
    @Test
    public void exercitoCom1Elfo(){
        ExercitoEspecialDeElfos exercitoEspecialDeElfos = new ExercitoEspecialDeElfos();
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(new Elfo("legolas"));
        assertEquals(0, exercitoEspecialDeElfos.getExercitoEspecialDeElfos().length);
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoE1ElfoVerde(){
        ExercitoEspecialDeElfos exercitoEspecialDeElfos = new ExercitoEspecialDeElfos();
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(new ElfoVerde("legolas"));
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(new ElfoNoturno("legolasNoturno"));
        assertEquals(2, exercitoEspecialDeElfos.getExercitoEspecialDeElfos().length);
    }
    
    @Test
    public void exercitoCom1ElfoVerdeEAtiraFlecha(){
        ExercitoEspecialDeElfos exercitoEspecialDeElfos = new ExercitoEspecialDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("legolas");
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(elfoVerde);
        elfoVerde.atirarFlecha(new Dwarf());
        assertEquals(41, exercitoEspecialDeElfos.getExercitoEspecialDeElfos()[0].getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoE1ElfoVerdeEBuscaNoturnoPorNome(){
        ExercitoEspecialDeElfos exercitoEspecialDeElfos = new ExercitoEspecialDeElfos();
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(new ElfoVerde("legolas"));
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(new ElfoNoturno("legolasDemonio"));
        assertEquals(new ElfoNoturno("legolasDemonio"), exercitoEspecialDeElfos.buscarPorNome("legolasDemonio"));
    }
    
    @Test
    public void exercitoCom1ElfoNoturnoMortoE1ElfoVerdeVivo(){
        ExercitoEspecialDeElfos exercitoEspecialDeElfos = new ExercitoEspecialDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("legolasDemonio", 100);
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(elfoNoturno);
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(new ElfoVerde("legolas"));
        for(int i = 0; i < 100; i++){
            elfoNoturno.atirarFlecha(new Dwarf());
        }
        assertTrue(exercitoEspecialDeElfos.buscarPorStatus(Status.MORTO).contains(elfoNoturno));
    }
    
    @Test
    public void exercitoCom3ElfosVerdesVivosEBuscaPorStatus(){
        ExercitoEspecialDeElfos exercitoEspecialDeElfos = new ExercitoEspecialDeElfos();
        ElfoVerde e1 = new ElfoVerde("e1");
        ElfoVerde e2 = new ElfoVerde("e2");
        ElfoVerde e3 = new ElfoVerde("e3");
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(e1);
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(e2);
        exercitoEspecialDeElfos.alistarElfoDoExercitoEspecial(e3);
        ArrayList<Elfo> comparar = new ArrayList<>();
        comparar.add(e1);
        comparar.add(e2);
        comparar.add(e3);
        assertEquals(comparar, exercitoEspecialDeElfos.buscarPorStatus(Status.VIVO));
    }
}
