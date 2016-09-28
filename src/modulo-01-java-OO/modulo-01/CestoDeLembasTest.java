

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste CestoDeLembasTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class CestoDeLembasTest
{
    @Test
    public void cestoCom2Lembas(){
        // Act
        CestoDeLembas doisSemGluten = new CestoDeLembas(2);
         // deve retornar false, pois 2 = 1 + 1
        // Assert
        assertEquals(2, doisSemGlutem.getQuantidade());
        assertEquals(false, doisSemGluten.podeDividirEmPares());
    }
    
    @Test
    public void cestoCom6Lembas(){
        // Act
        CestoDeLembras seisSemGluten = new CestoDeLembas(6);
        seisSemGluten.podeDividirEmPares(); // true, pois 6 = 2 + 4
        assertEquals(true, doisSemGluten.podeDividirEmPares());
    }
}
