import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110Vida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaUmaVez() {
        Dwarf gimli = new Dwarf();
        gimli.fuiAtingido();
        assertEquals(100, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaDuasVezes() {
        Dwarf gimli = new Dwarf();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        assertEquals(90, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaVinteVezes() {
        Dwarf gimli = new Dwarf();
        gimli.fuiAtingido(20);
        assertEquals(-90, gimli.getVida());
    }
    
    @Test
    public void dwarfNasceComVidaComNomeEDataNascimento(){
        Dwarf gimli = new Dwarf("gimli", new DataTerceiraEra(1, 12, 3019));
        assertEquals(110, gimli.getVida());
        assertEquals("gimli", gimli.getNome());
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(12, gimli.getDataNascimento().getMes());
        assertEquals(3019, gimli.getDataNascimento().getAno());
    }
}



