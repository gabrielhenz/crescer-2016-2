import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest {
    @After
    // executa após cada cenário de testes.
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void elfoNasceComNome() {
        // Arrange
        String nomeEsperado = "Bruce Wayne";
        // Act
        Elfo elfoDoTeste = new Elfo(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, elfoDoTeste.getNome());
    }

    @Test
    public void elfoNasceCom100DeVida() {
        assertEquals(100, new Elfo("Legolas").getVida(), 0.);
    }

    @Test
    public void elfoNasceComArco() {
        // Act
        Elfo elfoDoTeste = new Elfo("Elrond");
        // Assert
        assertEquals("Arco", elfoDoTeste.getInventario().getItens().get(0).getDescricao());
        assertEquals(1, elfoDoTeste.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlecha(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        // Assert
        assertEquals("Flechas", elfoDoTeste.getInventario().getItens().get(1).getDescricao());
        assertEquals(42, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlechas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", 10);
        // Assert
        assertEquals("Flechas", elfoDoTeste.getInventario().getItens().get(1).getDescricao());
        assertEquals(10, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void elfoNasceComZeroFlechas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", 0);
        // Assert
        assertEquals("Flechas", elfoDoTeste.getInventario().getItens().get(1).getDescricao());
        assertEquals(0, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
    }
    
    
     @Test
    public void elfoNasceComFlechasNegativas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", -10);
        // Assert
        assertEquals("Flechas", elfoDoTeste.getInventario().getItens().get(1).getDescricao());
        assertEquals(42, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
    }
    
    
    @Test
    public void elfoAtiraUmaFlecha(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(new Dwarf());
        // Assert
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(41, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void elfoAtiraUmaFlechaDiferenteDe42(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", 10);
        elfoDoTeste.atirarFlecha(new Dwarf());
        // Assert
    }
    
    @Test
    public void elfoAtira10Flechas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        Dwarf gimli = new Dwarf();
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        // Assert
        assertEquals(10, elfoDoTeste.getExperiencia());
        assertEquals(32, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
    }
    
    @Test
    public void elfoAtiraFlechaEmUmDwarf() {
        Elfo elfo = new Elfo("Batman");
        Dwarf balin = new Dwarf();
        elfo.atirarFlecha(balin);
        assertEquals(100, balin.getVida(), 0.);
    }
    
    @Test
    public void elfoAtiraDuasFlechaEmUmDwarf() {
        Elfo elfo = new Elfo("Batman");
        Dwarf balin = new Dwarf();
        elfo.atirarFlecha(balin);
        elfo.atirarFlecha(balin);
        assertEquals(90, balin.getVida(), 0.);
    }
    
    
    @Test
    public void elfoAtiraUmaFlechaEmCadaDwarf() {
        Elfo elfo = new Elfo("Batman");
        Dwarf balin = new Dwarf();
        Dwarf gloin = new Dwarf();
        elfo.atirarFlecha(balin);
        elfo.atirarFlecha(gloin);
        assertEquals(100, balin.getVida(), 0.);
        assertEquals(100, gloin.getVida(), 0.);
    }
    
    
    @Test
    public void elfoAtiraFlechaNoDwarfX(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        Dwarf X = new Dwarf();
        elfoDoTeste.atirarFlecha(X);
        // Assert
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(41, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals(100, X.getVida(), .0);
    }
    
    @Test
    public void elfoAtiraFlechaNoDwarfX_Y(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        Dwarf X = new Dwarf();
        Dwarf Y = new Dwarf();
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(Y);
        // Assert
        assertEquals(2, elfoDoTeste.getExperiencia());
        assertEquals(40, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals(100, X.getVida(), .0);
        assertEquals(100, Y.getVida(), .0);
    }
    
    @Test
    public void elfoAtira10FlechasNoDwarfXE11FlechasNoDwarfY(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        Dwarf X = new Dwarf();
        Dwarf Y = new Dwarf();
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(X);
        elfoDoTeste.atirarFlecha(X);
        
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        elfoDoTeste.atirarFlecha(Y);
        // Assert
        assertEquals(21, elfoDoTeste.getExperiencia());
        assertEquals(21, elfoDoTeste.getInventario().getItens().get(1).getQuantidade());
        assertEquals(10, X.getVida(), .0);
        assertEquals(0, Y.getVida(), .0);
    }

    @Test
    public void elfoNasceToString(){
        // Act & Arrange
        Elfo elfoDoTeste = new Elfo("bilbo");
        // Assert
        assertEquals("bilbo possui 42 flechas e 0 níveis de experiência.", elfoDoTeste.toString());
    }

    @Test
    public void elfoNasceSemFlechasToString(){
        // Act & Arrange
        Elfo elfoDoTeste = new Elfo("bilbo", 0);
        // Assert
        assertEquals("bilbo possui 0 flechas e 0 níveis de experiência.", elfoDoTeste.toString());
    }

    @Test
    public void elfoNasceComFlechasNegativasToString(){
        // Act & Arrange
        Elfo elfoDoTeste = new Elfo("bilbo", -12);
        // Assert
        assertEquals("bilbo possui 42 flechas e 0 níveis de experiência.", elfoDoTeste.toString());
    }

    @Test
    public void elfoNasceAtiraUmaFlechaToString(){
        // Act & Arrange
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(new Dwarf());
        // Assert
        assertEquals("bilbo possui 41 flechas e 1 nível de experiência.", elfoDoTeste.toString());
    }

    @Test public void elfoNasceVivo() {
        Elfo elfo = new Elfo("Cobaia");
        assertEquals(Status.VIVO, elfo.getStatus());
    }

    @Test
    public void aoCriarElfoIncrementaContador() {
        new Elfo("Nyna Magsandoral");
        assertEquals(1, Elfo.getContadorDeElfos());
    }

    @Test
    public void aoCriarVariosElfosIncrementaContador() {
        new Elfo("Nyna Magsandoral");
        new ElfoVerde("Flardryn Brynan");
        new Elfo("Isilfarrel Xilrieth");
        assertEquals(3, Elfo.getContadorDeElfos());
    }

}


