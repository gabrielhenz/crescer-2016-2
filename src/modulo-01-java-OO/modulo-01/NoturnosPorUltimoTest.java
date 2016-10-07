

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NoturnosPorUltimoTest
{
    
    @Test
    public void ordenaSemElfosNaLista(){
        assertNull(instancia().getOrdemDeAtaque(new ArrayList<Elfo>()));
    }
    
    @Test
    public void ordenaCom3ElfosVerdesE3ElfosNoturnos(){
        assertEquals(
            retorna3ElfosVerdesE3ElfosNoturnosOrdenados(),
            instancia().getOrdemDeAtaque(retorna3ElfosVerdesE3ElfosNoturnosDesordenados())
        );
    }
    
    @Test
    public void ordenaCom3ElfosVerdes(){
        List<Elfo> elfos = retorna3ElfosVerdes();
        assertEquals(elfos, instancia().getOrdemDeAtaque(elfos));
    }
    
    @Test
    public void ordenaCom3ElfosNoturnos(){
        List<Elfo> elfos = retorna3ElfosNoturnos();
        assertEquals(elfos, instancia().getOrdemDeAtaque(elfos));
    }
    
    private NoturnosPorUltimo instancia(){
        List<Elfo> elfos = retorna3ElfosNoturnos();
        return new NoturnosPorUltimo();
    }
    
    private List<Elfo> retorna3ElfosVerdesE3ElfosNoturnosDesordenados(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoVerde("verde1"),
                    new ElfoNoturno("noturno1"),
                    new ElfoNoturno("noturno2"),
                    new ElfoVerde("verde2"),
                    new ElfoNoturno("noturno3"),
                    new ElfoVerde("verde3")
                )
             );
    }
    
    private List<Elfo> retorna3ElfosVerdesE3ElfosNoturnosOrdenados(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoVerde("verde1"),
                    new ElfoVerde("verde2"),
                    new ElfoVerde("verde3"),
                    new ElfoNoturno("noturno1"),
                    new ElfoNoturno("noturno2"),
                    new ElfoNoturno("noturno3")
                )
             );
    }
    
    private List<Elfo> retorna3ElfosVerdes(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoVerde("verde1"),
                    new ElfoVerde("verde2"),
                    new ElfoVerde("verde3")
                )
             );
    }
    
    private List<Elfo> retorna3ElfosNoturnos(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoNoturno("noturno1"),
                    new ElfoNoturno("noturno2"),
                    new ElfoNoturno("noturno3")
                )
             );
    }
}
