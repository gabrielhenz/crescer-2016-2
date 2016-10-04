

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeNasceComArcoDeVidroE42FlechasDeVidro(){
        ElfoVerde elfoVerde = new ElfoVerde("Legolas");
        ArrayList<Item> itens = elfoVerde.getInventario().getItens();
        assertEquals("Arco de Vidro", itens.get(0).getDescricao());
        assertEquals(1, itens.get(0).getQuantidade());
        assertEquals("Flechas de Vidro", itens.get(1).getDescricao());
        assertEquals(42, itens.get(1).getQuantidade());
    }
    
    @Test
    public void elfoVerdeNasceComArcoDeVidroESemFlechasDeVidro(){
        ElfoVerde elfoVerde = new ElfoVerde("Legolas", 0);
        ArrayList<Item> itens = elfoVerde.getInventario().getItens();
        assertEquals("Arco de Vidro", itens.get(0).getDescricao());
        assertEquals(1, itens.get(0).getQuantidade());
        assertEquals("Flechas de Vidro", itens.get(1).getDescricao());
        assertEquals(0, itens.get(1).getQuantidade());
    }
    
    @Test
    public void elfoVerdeNasceComArcoDeVidroEMenos10FlechasDeVidro(){
        ElfoVerde elfoVerde = new ElfoVerde("Legolas", -10);
        ArrayList<Item> itens = elfoVerde.getInventario().getItens();
        assertEquals("Arco de Vidro", itens.get(0).getDescricao());
        assertEquals(1, itens.get(0).getQuantidade());
        assertEquals("Flechas de Vidro", itens.get(1).getDescricao());
        assertEquals(42, itens.get(1).getQuantidade());
    }
    
    @Test
    public void elfoVerdeNasceComArcoDeVidroE42FlechasDeVidroEAtira1Flecha(){
        ElfoVerde elfoVerde = new ElfoVerde("Legolas", -10);
        elfoVerde.atirarFlecha(new Dwarf());
        assertEquals(41, elfoVerde.getInventario().getItens().get(1).getQuantidade());
        assertEquals(2, elfoVerde.getExperiencia());
    }
}
