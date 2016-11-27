/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.chart.PieChart.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class MeuCalendarioUtilTest {
    
    private static MeuCalendarioUtil MEU_CALENDARIO_UTIL = new MeuCalendarioUtil();
    
    @Test
    public void testDiaDaSemanaDoNascimento(){
        Assert.assertEquals("Sábado", 
                MEU_CALENDARIO_UTIL.diaDaSemanaDoNascimento(
                        MEU_CALENDARIO_UTIL.conversaoStringParaData("26/11/2016")
                ));
    }
    
    @Test
    public void testDiaDaSemanaDoNascimentoComStringVazia(){
        Assert.assertNull(
                MEU_CALENDARIO_UTIL.diaDaSemanaDoNascimento(
                    MEU_CALENDARIO_UTIL.conversaoStringParaData("")
                ));
    }
    
    @Test
    public void testDiaDaSemanaDoNascimentoComNull(){
        Assert.assertNull(MEU_CALENDARIO_UTIL.diaDaSemanaDoNascimento(null));
    }
    
    
    @Test
    public void testDiferencaDeDatasComMenosUmDia(){
        Date data = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DAY_OF_MONTH, -1);
        data = c.getTime();
        SimpleDateFormat frmt = new SimpleDateFormat("dd/MM/yyyy");
        String dataTexto = frmt.format(data);
        Assert.assertEquals(
                "0 ano(s), 0 mes(es), 1 dia(s)", 
                MEU_CALENDARIO_UTIL.diferencaDeDatas(
                        MEU_CALENDARIO_UTIL.conversaoStringParaData(dataTexto)
                ));
    }
    
    /*
    @Test
    public void testDiferencaDeDatasComMaisUmDia(){
        Date data = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DAY_OF_MONTH, 1);
        data = c.getTime();
        SimpleDateFormat frmt = new SimpleDateFormat("dd/MM/yyyy");
        String dataTexto = frmt.format(data);
        Assert.assertEquals(
                "0 ano(s), 0 mes(es), 1 dia(s)", 
                MEU_CALENDARIO_UTIL.diferencaDeDatas(dataTexto));
    }
    */
    
    @Test
    public void testDiferencaDeDatasComDataNula(){
        Assert.assertNull(
                MEU_CALENDARIO_UTIL.diferencaDeDatas(null));
    }
}
