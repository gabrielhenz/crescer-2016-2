

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
    
    @Test
    public void criaInventarioEUmaListaDeItensEAddUmItemSemQuantidade(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Machado", 0));
        assertEquals("Machado", inventario.getItens().get(0).getDescricao());
        assertEquals(0, inventario.getItens().get(0).getQuantidade());
    }
    
    @Test
    public void criaInventarioEUmaListaDeItensEAddUmItemERemoveUmItem(){
        Inventario inventario = new Inventario();
        Item item = new Item("Machado", 1);
        inventario.adicionarItem(item);
        inventario.removerItem(item);
        assertEquals(0, inventario.getItens().size());
    }
    
    @Test
    public void criaInventarioEUmaListaDeItensEAddTresItensERemoveOSegundoItem(){
        Inventario inventario = new Inventario();
        Item item1 = new Item("Machado", 1);
        Item item2 = new Item("Arco", 1);
        Item item3 = new Item("Poção de vida", 1);
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        inventario.removerItem(item2);
        assertEquals("Machado", inventario.getItens().get(0).getDescricao());
        assertEquals(1, inventario.getItens().get(0).getQuantidade());
        assertEquals("Poção de vida", inventario.getItens().get(1).getDescricao());
        assertEquals(1, inventario.getItens().get(1).getQuantidade());
    }
    
    @Test
    public void criaInventarioAdd3ItensEImprime(){
        Inventario inventario = new Inventario();
        Item item1 = new Item("Machado", 1);
        Item item2 = new Item("Arco", 1);
        Item item3 = new Item("Poção de vida", 1);
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        assertEquals("Machado,Arco,Poção de vida", inventario.getDescricoesItens());
    }
    
    @Test
    public void criaInventarioSemItensETentaImprimir(){
        Inventario inventario = new Inventario();
        assertEquals(null, inventario.getDescricoesItens());
    }
    
    @Test 
    public void criaInventarioAdd2ItensEVerificaMaisPopular(){
        Inventario inventario = new Inventario();
        Item item = new Item("Arco", 2);
        inventario.adicionarItem(new Item("Machado", 1));
        inventario.adicionarItem(item);
        assertEquals(item, inventario.itemMaisPopular());
    }
    
    @Test 
    public void criaInventarioAdd1ItensEVerificaMaisPopular(){
        Inventario inventario = new Inventario();
        Item item = new Item("Arco", 2);
        inventario.adicionarItem(item);
        assertEquals(item, inventario.itemMaisPopular());
    }
    
    @Test 
    public void criaInventarioSemItensEVerificaMaisPopular(){
        Inventario inventario = new Inventario();
        assertEquals(null, inventario.itemMaisPopular());
    }
}
