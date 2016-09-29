

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DataTerceiraEraTest
{
    @Test
    public void criaData(){
        DataTerceiraEra fimDaGuerraDoAnel = new DataTerceiraEra(1, 10, 3019);
        assertEquals(1, fimDaGuerraDoAnel.getDia());
        assertEquals(10, fimDaGuerraDoAnel.getMes());
        assertEquals(3019, fimDaGuerraDoAnel.getAno());
    }
    
    @Test
    public void criaDataNaoBissextaETestaSeEh(){
        DataTerceiraEra fimDaGuerraDoAnel = new DataTerceiraEra(1, 10, 3019);
        assertFalse(fimDaGuerraDoAnel.ehBissexto());
    }
    
    @Test
    public void criaDataBissextaETestaSeEh(){
        DataTerceiraEra fimDaGuerraDoAnel = new DataTerceiraEra(1, 10, 2000);
        assertTrue(fimDaGuerraDoAnel.ehBissexto());
    }
}
