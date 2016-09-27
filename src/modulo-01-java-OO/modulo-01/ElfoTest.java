import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoTest
{
    @Test
    public void elfoNasceComNome(){
        //Arrange
        Item arco = new Item("Arco", 1);
        //Act
        Elfo elfoDoTeste = new Elfo("Elrond");
        //Assert
        assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }
}
