import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
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
    public void elfoNasceComArco() {
        // Act
        Elfo elfoDoTeste = new Elfo("Elrond");
        // Assert
        assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlecha(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        // Assert
        assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlechas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", 10);
        // Assert
        assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(10, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoNasceComZeroFlechas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", 0);
        // Assert
        assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    
     @Test
    public void elfoNasceComFlechasNegativas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", -10);
        // Assert
        assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    
    @Test
    public void elfoAtiraUmaFlecha(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(new Dwarf());
        // Assert
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
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
        assertEquals(32, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtira42FlechasComElfoDeFlechasDefault(){
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
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        // Assert
        assertEquals(42, elfoDoTeste.getExperiencia());
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraMaisQue42FlechasComElfoDeFlechasDefault(){
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
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli); // "flechas 43"
        // Assert
        assertEquals(42, elfoDoTeste.getExperiencia());
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    
    @Test
    public void elfoAtiraFlechasComElfoDeFlechasNegativas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", -10);
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
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        elfoDoTeste.atirarFlecha(gimli);
        // Assert
        assertEquals(15, elfoDoTeste.getExperiencia());
        assertEquals(27, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    
    @Test
    public void elfoAtiraFlechaNoDwarfX(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        Dwarf X = new Dwarf();
        elfoDoTeste.atirarFlecha(X);
        // Assert
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(100, X.getVida());
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
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(100, X.getVida());
        assertEquals(100, Y.getVida());
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
        assertEquals(21, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(10, X.getVida());
        assertEquals(0, Y.getVida());
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
    
    @Test
    public void elfoNasceAtira41FlechasToString(){
        // Act & Arrange
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
        elfoDoTeste.atirarFlecha(gimli);
        // Assert
        assertEquals("bilbo possui 1 flecha e 41 níveis de experiência.", elfoDoTeste.toString());
    }
    
    @Test
    public void elfoNasceVivo(){
        Elfo elfo = new Elfo("Cobaia");
        assertEquals(Status.VIVO, elfo.getStatus());
    }
    
}




