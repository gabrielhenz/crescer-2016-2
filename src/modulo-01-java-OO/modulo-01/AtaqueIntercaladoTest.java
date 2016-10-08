

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest
{
    @Test
    public void ordenaSemElfosNaLista() throws ContemElfoNormalException, ContingenteDesproporcionalException{
        assertNull(instancia().getOrdemDeAtaque(new ArrayList<Elfo>()));
    }
    
    @Test (expected=ContingenteDesproporcionalException.class)
    public void ordenaCom3ElfosVerdes() throws ContemElfoNormalException, ContingenteDesproporcionalException{
        List<Elfo> elfos = GeradorDeElfos.retorna3ElfosVerdes();
        assertNull(instancia().getOrdemDeAtaque(elfos));
    }
    
    @Test
    public void ordenaCom3ElfosVerdesE3ElfosNoturnosComVerdeNoInicio() throws ContemElfoNormalException, ContingenteDesproporcionalException{
        assertEquals(
            GeradorDeElfos.retorna3ElfosVerdesE3ElfosNoturnosIntercaladosComVerdeNoInicio(),
            instancia().getOrdemDeAtaque(GeradorDeElfos.retorna3ElfosVerdesE3ElfosNoturnosDesordenadosComVerdeNoInicio())
        );
    }
    
    @Test
    public void ordenaCom3ElfosVerdesE3ElfosNoturnosComNoturnoNoInicio() throws ContemElfoNormalException, ContingenteDesproporcionalException{
        assertEquals(
            GeradorDeElfos.retorna3ElfosVerdesE3ElfosNoturnosIntercaladosComNoturnoNoInicio(),
            instancia().getOrdemDeAtaque(GeradorDeElfos.retorna3ElfosVerdesE3ElfosNoturnosDesordenadosComNoturnoNoInicio())
        );
    }
    
    
    /*
     * Ver com o instrutor Bernardo como fazer testes para uma Exception esperada.
     */
    @Test
    public void ordenaCom3ElfosVerdes3ElfosNoturnosE3ElfosNormaisIntercaladoThrowsContemElfoNormalException() throws ContemElfoNormalException, ContingenteDesproporcionalException{
        /*try{
            instancia().getOrdemDeAtaque(GeradorDeElfos.retorna3ElfosVerdes3ElfosNoturnosE3ElfosNormaisOrdenados());
        }catch(ContemElfoNormalException contemElfoNormalException){
            System.out.println(
                contemElfoNormalException.getMessage() +
                contemElfoNormalException.getStackTrace()
            );
        }*/
        
        boolean contemElfo = false;
        try{
            List<Elfo> elfos = instancia().getOrdemDeAtaque(GeradorDeElfos.retorna3ElfosVerdes3ElfosNoturnosE3ElfosNormaisOrdenados());
        }catch(ContemElfoNormalException contemElfoNormalException){
            contemElfo = true;
        }
        
        assertTrue(contemElfo);
    }
    
    private AtaqueIntercalado instancia(){
        return new AtaqueIntercalado();
    }
}
