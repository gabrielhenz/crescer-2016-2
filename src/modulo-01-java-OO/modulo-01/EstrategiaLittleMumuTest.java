

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaLittleMumuTest
{
    @Test
    public void ordenaComUmaListaVazia()throws ContemElfoNormalException{
        assertNull(instancia().getOrdemDeAtaque(new ArrayList<Elfo>()));
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
    
    @Test
    public void ordenaCom2ElfosVerdes1ElfoVerdeSemFlechasE2ElfosNoturnos() throws ContemElfoNormalException{
        assertEquals(
            GeradorDeElfos.retorna2ElfosVerdesE1ElfosNoturno(),
            instancia()
            .getOrdemDeAtaque(GeradorDeElfos.retorna2ElfosVerdes1ElfoVerdeSemFlechasE2ElfosNoturnos())
        );
    }
    
    @Test
    public void ordenaCom2ElfosVerdes1ElfoVerdeSemFlechasE2ElfosNoturnosEQuantidadeDeFlechasDiferentes()throws ContemElfoNormalException{
        assertEquals(
            GeradorDeElfos
            .retorna2ElfosVerdesE1ElfosNoturnoComQuantidadeDeFlechasOrdenadasDescendente(),
            instancia()
            .getOrdemDeAtaque(
                GeradorDeElfos
                .retorna2ElfosVerdes1ElfoVerdeSemFlechasE2ElfosNoturnosComQuantidadeDeFlechasDiferentes()
            )
        );
    }
    
    
    
    
    private EstrategiaLittleMumu instancia(){
        return new EstrategiaLittleMumu();
    }
    
    
}
