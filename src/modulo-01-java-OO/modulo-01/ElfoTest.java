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
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(9, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraVariasFlechas(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(10);
        // Assert
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(32, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtira42FlechasComElfoDeFlechasDefault(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(42);
        // Assert
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(0, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraMaisQue42FlechasComElfoDeFlechasDefault(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(43);
        // Assert
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(-1, elfoDoTeste.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraMenosQueZeroComFlechasDefault(){
        // Act
        Elfo elfoDoTeste = new Elfo("bilbo");
        elfoDoTeste.atirarFlecha(-10);
        // Assert
        assertEquals(1, elfoDoTeste.getExperiencia());
        assertEquals(52, elfoDoTeste.getFlecha().getQuantidade());
    }
}