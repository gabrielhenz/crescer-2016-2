

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
    public void getDescricoesItensComApenasUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Bracelete", 56));
        assertEquals("Bracelete", inventario.getDescricoesItens());
    }

    @Test
    public void getDescricoesItensSemItens() {
        Inventario inventario = new Inventario();
        assertEquals("", inventario.getDescricoesItens());
    }

    @Test
    public void aumentar1000UnidadesDosItens() {
        Inventario inventario = criarInventarioCom3Itens();
        inventario.aumentarUnidadesDosItens(1000);
        assertEquals(1002, inventario.getItens().get(0).getQuantidade());
        assertEquals(1045, inventario.getItens().get(1).getQuantidade());
        assertEquals(1003, inventario.getItens().get(2).getQuantidade());
    }

    @Test
    public void aumentar1UnidadeDosItens() {
        Inventario inventario = criarInventarioCom3Itens();
        inventario.aumentarUnidadesDosItens(1);
        assertEquals(3, inventario.getItens().get(0).getQuantidade());
        assertEquals(46, inventario.getItens().get(1).getQuantidade());
        assertEquals(4, inventario.getItens().get(2).getQuantidade());
    }

    @Test
    public void aumentar0UnidadeDosItens() {
        Inventario inventario = criarInventarioCom3Itens();
        inventario.aumentarUnidadesDosItens(0);
        assertEquals(2, inventario.getItens().get(0).getQuantidade());
        assertEquals(45, inventario.getItens().get(1).getQuantidade());
        assertEquals(3, inventario.getItens().get(2).getQuantidade());
    }

    @Test
    public void aumentarUnidadeSemItens() {
    
    @Test 
    public void criaInventarioSemItensEVerificaMaisPopular(){
        Inventario inventario = new Inventario();
        assertEquals(null, inventario.itemMaisPopular());
    }

    @Test
    public void itemComMaiorQuantidadeCom3Itens() {
        Inventario inventario = criarInventarioCom3Itens();
        Item item = inventario.getItemComMaiorQuantidade();
        assertEquals("Poção polissuco", item.getDescricao());
        assertEquals(45, item.getQuantidade());
    }

    @Test
    public void itemComMaiorQuantidadeCom3ItensDeQuantidadesIguais() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.adicionarItem(new Item("Poção polissuco", 2));
        inventario.adicionarItem(new Item("Lucky egg", 2));
        Item item = inventario.getItemComMaiorQuantidade();
        assertEquals("Espada de aço", item.getDescricao());
        assertEquals(2, item.getQuantidade());
    }

    @Test
    public void itemComMaiorQuantidadeComInventarioVazio() {
        Inventario inventario = new Inventario();
        Item item = inventario.getItemComMaiorQuantidade();
        assertNull(item);
    }

    @Test
    public void ordenarItensBaguncados() {
        // Arrange
        Inventario mochila = new Inventario();
        Item armadura = new Item("Armadura", 9);
        Item escudo = new Item("Escudo", 99);
        Item canivete = new Item("Canivete suíço", 2);
        mochila.adicionarItem(armadura);
        mochila.adicionarItem(escudo);
        mochila.adicionarItem(canivete);
        // Act
        mochila.ordenarItens();
        // Assert
        assertEquals(canivete, mochila.getItens().get(0));
        assertEquals(armadura, mochila.getItens().get(1));
        assertEquals(escudo, mochila.getItens().get(2));
    }

    @Test
    public void ordenarItensComMesmaQuantidade() {
        // Arrange
        Inventario mochila = new Inventario();
        Item elderScroll = new Item("Elder Scroll", 9);
        Item escudo = new Item("Escudo", 9);
        Item canivete = new Item("Canivete suíço", 9);
        mochila.adicionarItem(elderScroll);
        mochila.adicionarItem(escudo);
        mochila.adicionarItem(canivete);
        // Act
        mochila.ordenarItens();
        // Assert
        assertEquals(elderScroll, mochila.getItens().get(0));
        assertEquals(escudo, mochila.getItens().get(1));
        assertEquals(canivete, mochila.getItens().get(2));
    }

    @Test
    public void ordenarItensVazio() {
        // Arrange
        Inventario mochila = new Inventario();
        // Act
        mochila.ordenarItens();
        // Assert
        assertEquals(0, mochila.getItens().size());
    }

    @Test
    public void aumentarUnidadesProporcionalComInventarioVazio() {
        Inventario inventario = new Inventario();
        inventario.aumentarUnidadesProporcionalQuantidadePorItem();
        assertTrue(inventario.getItens().isEmpty());
    }

    @Test
    public void aumentarUnidadesProporcionalComApenasUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 1));
        inventario.aumentarUnidadesProporcionalQuantidadePorItem();
        assertEquals(1001, inventario.getItens().get(0).getQuantidade());
    }

    @Test
    public void aumentarUnidadesProporcionalComApenasDoisItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Balas .44", 2));
        inventario.adicionarItem(new Item("Balas .12", 3));
        inventario.aumentarUnidadesProporcionalQuantidadePorItem();
        assertEquals(3002, inventario.getItens().get(0).getQuantidade());
        assertEquals(6003, inventario.getItens().get(1).getQuantidade());
    }

    @Test
    public void cria3ItensEOrdenaAscendente(){
        Inventario inventario = criarInventarioCom3Itens();
        inventario.ordenarItens();
        assertEquals("Espada de aço", inventario.getItens().get(0).getDescricao());
        assertEquals(2, inventario.getItens().get(0).getQuantidade());
        assertEquals("Lucky egg", inventario.getItens().get(1).getDescricao());
        assertEquals(3, inventario.getItens().get(1).getQuantidade());
        assertEquals("Poção polissuco", inventario.getItens().get(2).getDescricao());
        assertEquals(45, inventario.getItens().get(2).getQuantidade());
    }
    
    @Test
    public void cria1ItemEOrdenaAscendente(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.ordenarItens();
        assertEquals("Espada de aço", inventario.getItens().get(0).getDescricao());
        assertEquals(2, inventario.getItens().get(0).getQuantidade());
    }
    
    @Test
    public void naoCriaItensEOrdenaAscendente(){
        Inventario inventario = new Inventario();
        inventario.ordenarItens();
        assertEquals(0, inventario.getItens().size());
    }
    
    @Test
    public void cria9tensEOrdenaAscendente(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 1));
        inventario.adicionarItem(new Item("Poção polissuco", 8));
        inventario.adicionarItem(new Item("Lucky egg", 4));
        inventario.adicionarItem(new Item("Toddynho", 7));
        inventario.adicionarItem(new Item("Poção de vida", 6));
        inventario.adicionarItem(new Item("Giphy", 5));
        inventario.adicionarItem(new Item("Arco", 0));
        inventario.adicionarItem(new Item("Flechas", 3));
        inventario.adicionarItem(new Item("Machado", 2));
        inventario.ordenarItens();
        assertEquals("Arco", inventario.getItens().get(0).getDescricao());
        assertEquals(0, inventario.getItens().get(0).getQuantidade());
        assertEquals("Espada de aço", inventario.getItens().get(1).getDescricao());
        assertEquals(1, inventario.getItens().get(1).getQuantidade());
        assertEquals("Machado", inventario.getItens().get(2).getDescricao());
        assertEquals(2, inventario.getItens().get(2).getQuantidade());
        assertEquals("Flechas", inventario.getItens().get(3).getDescricao());
        assertEquals(3, inventario.getItens().get(3).getQuantidade());
        assertEquals("Lucky egg", inventario.getItens().get(4).getDescricao());
        assertEquals(4, inventario.getItens().get(4).getQuantidade());
        assertEquals("Giphy", inventario.getItens().get(5).getDescricao());
        assertEquals(5, inventario.getItens().get(5).getQuantidade());
        assertEquals("Poção de vida", inventario.getItens().get(6).getDescricao());
        assertEquals(6, inventario.getItens().get(6).getQuantidade());
        assertEquals("Toddynho", inventario.getItens().get(7).getDescricao());
        assertEquals(7, inventario.getItens().get(7).getQuantidade());
        assertEquals("Poção polissuco", inventario.getItens().get(8).getDescricao());
        assertEquals(8, inventario.getItens().get(8).getQuantidade());
    }
    
    @Test
    public void cria9tensEOrdenaDescendente(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 1));
        inventario.adicionarItem(new Item("Poção polissuco", 8));
        inventario.adicionarItem(new Item("Lucky egg", 4));
        inventario.adicionarItem(new Item("Toddynho", 7));
        inventario.adicionarItem(new Item("Poção de vida", 6));
        inventario.adicionarItem(new Item("Giphy", 5));
        inventario.adicionarItem(new Item("Arco", 0));
        inventario.adicionarItem(new Item("Flechas", 3));
        inventario.adicionarItem(new Item("Machado", 2));
        inventario.ordenarItens(TipoOrdenacao.DESCENDENTE);
        assertEquals("Poção polissuco", inventario.getItens().get(0).getDescricao());
        assertEquals(8, inventario.getItens().get(0).getQuantidade());
        assertEquals("Toddynho", inventario.getItens().get(1).getDescricao());
        assertEquals(7, inventario.getItens().get(1).getQuantidade());
        assertEquals("Poção de vida", inventario.getItens().get(2).getDescricao());
        assertEquals(6, inventario.getItens().get(2).getQuantidade());
        assertEquals("Giphy", inventario.getItens().get(3).getDescricao());
        assertEquals(5, inventario.getItens().get(3).getQuantidade());
        assertEquals("Lucky egg", inventario.getItens().get(4).getDescricao());
        assertEquals(4, inventario.getItens().get(4).getQuantidade());
        assertEquals("Flechas", inventario.getItens().get(5).getDescricao());
        assertEquals(3, inventario.getItens().get(5).getQuantidade());
        assertEquals("Machado", inventario.getItens().get(6).getDescricao());
        assertEquals(2, inventario.getItens().get(6).getQuantidade());
        assertEquals("Espada de aço", inventario.getItens().get(7).getDescricao());
        assertEquals(1, inventario.getItens().get(7).getQuantidade());
        assertEquals("Arco", inventario.getItens().get(8).getDescricao());
        assertEquals(0, inventario.getItens().get(8).getQuantidade());
        
        
        
        
        
        
        
        
    }
    
    private Inventario criarInventarioCom3Itens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.adicionarItem(new Item("Poção polissuco", 45));
        inventario.adicionarItem(new Item("Lucky egg", 3));
        return inventario;
    }
}
