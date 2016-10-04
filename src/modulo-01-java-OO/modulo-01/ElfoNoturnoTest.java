

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoNasceComArcoE42FlechasE100DeVida(){
        ElfoNoturno elfoNoturno = new ElfoNoturno("Legolas Obscuro");
        ArrayList<Item> itens = elfoNoturno.getInventario().getItens();
        assertEquals("Arco", itens.get(0).getDescricao());
        assertEquals("Flechas", itens.get(1).getDescricao());
        assertEquals(100, elfoNoturno.getVida(), .0);
    }
    
    @Test
    public void elfoNoturnoNasceComArcoE42FlechasE100DeVidaEAtira1Flecha(){
        ElfoNoturno elfoNoturno = new ElfoNoturno("Legolas Obscuro");
        elfoNoturno.atirarFlecha(new Dwarf());
        assertEquals(95, elfoNoturno.getVida(), .0);
        assertEquals(3, elfoNoturno.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoNasceComArcoE42FlechasE100DeVidaEAtira100FlechaEMorre(){
        ElfoNoturno elfoNoturno = new ElfoNoturno("Legolas Obscuro", 100);
        Dwarf dwarf = new Dwarf();
        
        for(int i = 0; i < 100; i++)
        elfoNoturno.atirarFlecha(dwarf);
        
        assertEquals(0, elfoNoturno.getVida(), 0.99);
        assertEquals(Status.MORTO, elfoNoturno.getStatus());
    }
}
