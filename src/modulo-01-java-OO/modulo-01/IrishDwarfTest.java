

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IrishDwarfTest
{
   @Test
    public void irishDwarfComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 5));
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfSemSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 5));
        dwarf.tentarSorte();
        assertEquals(5, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfComSorteEDoisItens() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 5));
        dwarf.adicionarItem(new Item("Batatas", 1));
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfComSorteESemItens() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.tentarSorte();
        assertEquals(0, dwarf.getInventario().getItens().size());
    }
    
    @Test
    public void irishDwarfQuantidadeNegativaComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", -5));
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.tentarSorte();
        assertEquals(14995, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
}
