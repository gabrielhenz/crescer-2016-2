

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void criaInventarioEUmaListaDeItensEAddUmItem(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Machado", 1));
        assertEquals("Machado", inventario.getItens().get(0).getDescricao());
        assertEquals(1, inventario.getItens().get(0).getQuantidade());
    }
}
