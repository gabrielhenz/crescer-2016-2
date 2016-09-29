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
    public void dwarfNasceVivo() {
        assertEquals(Status.VIVO, new Dwarf().getStatus());
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
        assertEquals(Status.VIVO, gimli.getStatus());
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
        assertEquals(0, gimli.getVida());
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
    
    @Test
    public void dwarfNasceComVidaEComDataNascimentoPadrao(){
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
        assertEquals(null, gimli.getNome());
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(1, gimli.getDataNascimento().getMes());
        assertEquals(1, gimli.getDataNascimento().getAno());
    }

    @Test
    public void dwarfPerdeVidaOnzeVezesZeraVidaEMorre() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(0, gimli.getVida());
        assertEquals(Status.MORTO, gimli.getStatus());
    }

    @Test
    public void dwarfCriadoInformandoNomeENascimento() {
        Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(12, 11, 1900));
        assertEquals("Gimli", gimli.getNome());
        assertEquals(12, gimli.getDataNascimento().getDia());
        assertEquals(11, gimli.getDataNascimento().getMes());
        assertEquals(1900, gimli.getDataNascimento().getAno());
    }

    @Test
    public void dwarfCriadoSemInformarNomeENascimento() {
        Dwarf gimli = new Dwarf();
        assertNull(gimli.getNome());
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(1, gimli.getDataNascimento().getMes());
        assertEquals(1, gimli.getDataNascimento().getAno());
    }

    @Test
    public void gerarNumeroAnoBissexto() {
        // Arrange
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(01, 01, 2016));
        // Act
        double resultado = bernardin.getNumeroSorte();
        // Assert
        assertEquals(101.0, resultado, .0);
    }
    
    @Test
    public void gerarElfoCom80DeVida() {
        // Arrange
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(01, 01, 2013));
        bernardin.fuiAtingido();
        bernardin.fuiAtingido();
        bernardin.fuiAtingido();
        // Act
        double resultado = bernardin.getNumeroSorte();
        // Assert
        assertEquals(101.0, resultado, .0);
    }
    
    @Test
    public void gerarElfoCom90DeVida() {
        // Arrange
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(01, 01, 2015));
        bernardin.fuiAtingido();
        bernardin.fuiAtingido();
        // Act
        double resultado = bernardin.getNumeroSorte();
        // Assert
        assertEquals(101.0, resultado, .0);
    }
    
    @Test
    public void gerarElfoCom80DeVidaEAnoBissexto() {
        // Arrange
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(01, 01, 2000));
        bernardin.fuiAtingido();
        bernardin.fuiAtingido();
        bernardin.fuiAtingido();
        // Act
        double resultado = bernardin.getNumeroSorte();
        // Assert
        assertEquals(-3333.0, resultado, .0);
    }
    
    @Test
    public void gerarElfoCom90DeVidaEAnoBissexto() {
        // Arrange
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(01, 01, 4000));
        bernardin.fuiAtingido();
        bernardin.fuiAtingido();
        // Act
        double resultado = bernardin.getNumeroSorte();
        // Assert
        assertEquals(-3333.0, resultado, .0);
    }
    
    @Test
    public void gerarNumeroAnoBissextoVidaEntre80e90() {
        // Arrange
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(01, 01, 2016));
        bernardin.fuiAtingido();
        bernardin.fuiAtingido();
        bernardin.fuiAtingido();
        // Act
        double resultado = bernardin.getNumeroSorte();
        // Assert
        assertEquals(-3333.0, resultado, .0);
    }

    @Test
    public void gerarNumeroAnoNaoBissextoNomeSeixas() {
        // Arrange
        Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(01, 01, 2015));
        // Act
        double resultado = seixas.getNumeroSorte();
        // Assert
        assertEquals(33.0, resultado, .0);
    }

    @Test
    public void gerarNumeroAnoNaoBissextoNomeMeireles() {
        // Arrange
        Dwarf seixas = new Dwarf("Meireles", new DataTerceiraEra(01, 01, 2015));
        // Act
        double resultado = seixas.getNumeroSorte();
        // Assert
        assertEquals(33.0, resultado, .0);
    }
    
    @Test
    public void gerarNumeroAnoBissextoNomeSeixas() {
        // Arrange
        Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(01, 01, 2016));
        // Act
        double resultado = seixas.getNumeroSorte();
        // Assert
        assertEquals(101.0, resultado, .0);
    }
    
    @Test
    public void gerarNumeroAnoBissextoNomeMeireles() {
        // Arrange
        Dwarf seixas = new Dwarf("Meireles", new DataTerceiraEra(01, 01, 2000));
        // Act
        double resultado = seixas.getNumeroSorte();
        // Assert
        assertEquals(101.0, resultado, .0);
    }

    @Test
    public void gerarNumeroSemEntrarNasCondicoes() {
        // Arrange
        Dwarf balin = new Dwarf("Balin", new DataTerceiraEra(1, 1, 2015));
        // Act
        double resultado = balin.getNumeroSorte();
        // Assert
        assertEquals(101.0, resultado, .0);
    }

    @Test
    public void dwarffuiAtingidoComNumeroSorteNegativo() {
        // Arrange
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,1,2000));
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        // Act
        dwarf.fuiAtingido();
        // Assert
        assertEquals(2, dwarf.getExperiencia());
        assertEquals(90, dwarf.getVida(), .0);   
    }

    @Test
    public void dwarffuiAtingidoComAnoNaoBissextoMeirelesNaoPerde() {
        Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(2, 3, 2015));
        meireles.fuiAtingido();
        assertEquals(0, meireles.getExperiencia());
        assertEquals(110, meireles.getVida(), .0);
    }

    @Test
    public void dwarffuiAtingidoNormal(){
        Dwarf dwarf = new Dwarf("André Nunin", new DataTerceiraEra(2, 3, 2015));
        dwarf.fuiAtingido();
        assertEquals(100, dwarf.getVida(), .0);
        assertEquals(0, dwarf.getExperiencia());
    }
    
    @Test
    public void dwarfNasceVivo(){
        Dwarf dwarf = new Dwarf();
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfNasceVivoPerde110DeVidaEMorre(){
        Dwarf dwarf = new Dwarf();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        assertEquals(0, dwarf.getVida());
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfNasceVivoEPerde120DeVidaEMorreSemFicarComVidaNegativa(){
        Dwarf dwarf = new Dwarf();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        dwarf.fuiAtingido();
        assertEquals(0, dwarf.getVida());
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
    
}

