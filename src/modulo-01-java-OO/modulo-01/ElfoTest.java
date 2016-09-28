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
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    
    @Test
    public void elfoAtiraUmaFlecha(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha();
        // Assert
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(41, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraUmaFlechaDiferenteDe42(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", 10);
        elfoDoTeste.atirarFlecha();
        // Assert
    }
    
    @Test
    public void elfoAtiraVariasFlechas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(10);
        // Assert
        assertEquals(10, elfoDoTeste.getExperiencia());
        assertEquals(32, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtira42FlechasComElfoDeFlechasDefault(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(42);
        // Assert
        assertEquals(42, elfoDoTeste.getExperiencia());
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraMaisQue42FlechasComElfoDeFlechasDefault(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(43);
        // Assert
        assertEquals(42, elfoDoTeste.getExperiencia());
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraMenosQueZeroComFlechasDefault(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(-10);
        // Assert
        assertEquals(0, elfoDoTeste.getExperiencia());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraZeroFlechasComElfoDeFlechasNegativas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", -10);
        elfoDoTeste.atirarFlecha(0);
        // Assert
        assertEquals(0, elfoDoTeste.getExperiencia());
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraFlechasComElfoDeFlechasNegativas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", -10);
        elfoDoTeste.atirarFlecha(15);
        // Assert
        assertEquals(0, elfoDoTeste.getExperiencia());
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraFlechasNegativasComElfoDeFlechasNegativas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo", -10);
        elfoDoTeste.atirarFlecha(-15);
        // Assert
        assertEquals(0, elfoDoTeste.getExperiencia());
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraFlechaNoDwarfX(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        Dwarf X = new Dwarf();
        elfoDoTeste.atirarFlechaEmDwarf(X);
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
        elfoDoTeste.atirarFlechaEmDwarf(X);
        elfoDoTeste.atirarFlechaEmDwarf(Y);
        // Assert
        assertEquals(2, elfoDoTeste.getExperiencia());
        assertEquals(40, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(100, X.getVida());
        assertEquals(100, Y.getVida());
    }
    
    @Test
    public void elfoAtiraFlechasNoDwarfX_Y(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        Dwarf X = new Dwarf();
        Dwarf Y = new Dwarf();
        elfoDoTeste.atirarFlechasEmDwarf(X, 10);
        elfoDoTeste.atirarFlechasEmDwarf(Y, 11);
        // Assert
        assertEquals(21, elfoDoTeste.getExperiencia());
        assertEquals(21, elfoDoTeste.getFlecha().getQuantidade());
        assertEquals(10, X.getVida());
        assertEquals(0, Y.getVida());
    }
}

