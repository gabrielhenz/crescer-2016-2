

import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;

public class NoturnosPorUltimoTest
{
    
    @Test
    public void ordenaSemElfosNaLista() throws ContemElfoNormalException{
        assertNull(instancia().getOrdemDeAtaque(new ArrayList<Elfo>()));
    }
    
    @Test 
    public void ordenaCom3ElfosVerdesE3ElfosNoturnos() throws ContemElfoNormalException{
        assertEquals(
            GeradorDeElfos.retorna3ElfosVerdesE3ElfosNoturnosOrdenados(),
            instancia().getOrdemDeAtaque(GeradorDeElfos.retorna3ElfosVerdesE3ElfosNoturnosDesordenadosComVerdeNoInicio())
        );
    }
    
    @Test
    public void ordenaCom3ElfosVerdes() throws ContemElfoNormalException{
        List<Elfo> elfos = GeradorDeElfos.retorna3ElfosVerdes();
        assertEquals(elfos, instancia().getOrdemDeAtaque(elfos));
    }
    
    @Test
    public void ordenaCom3ElfosNoturnos() throws ContemElfoNormalException{
        List<Elfo> elfos = GeradorDeElfos.retorna3ElfosNoturnos();
        assertEquals(elfos, instancia().getOrdemDeAtaque(elfos));
    }
    
    
    /*
     * Ver como fazer teste quando eu espero que dê uma exception.
     */
    @Test
    public void ordenaCom3ElfosVerdes3ElfosNoturnosE3ElfosNormaisThrowsContemElfoNormalException() throws ContemElfoNormalException{
        boolean contemElfoNormal = false;
        try {
          instancia().getOrdemDeAtaque(GeradorDeElfos.retorna3ElfosVerdes3ElfosNoturnosE3ElfosNormaisOrdenados());
        } catch (ContemElfoNormalException contemElfoNormalException) {
          System.out.println(
                contemElfoNormalException.getMessage() +
                contemElfoNormalException.getStackTrace()
            );
        }
    }
    
    private NoturnosPorUltimo instancia(){
        List<Elfo> elfos = GeradorDeElfos.retorna3ElfosNoturnos();
        return new NoturnosPorUltimo();
    }
    
    
}
