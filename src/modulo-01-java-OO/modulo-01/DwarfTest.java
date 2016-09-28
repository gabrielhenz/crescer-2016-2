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
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        gimli.fuiAtingido();
        assertEquals(-90, gimli.getVida());
    }
}



