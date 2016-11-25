/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabriel.henz
 */
public class MeuStringUtilTest {
    static MeuStringUtil meuStringUtil = new MeuStringUtil();
    
    @org.junit.Test
    public void testValidarStringVaziaComStringVazia() {
        String texto = "";
        Assert.assertTrue(meuStringUtil.ehStringVazia(texto));
    }
    
    @org.junit.Test
    public void testValidarStringVaziaComStringPopulada() {
        String texto = "Hello World!";
        Assert.assertFalse(meuStringUtil.ehStringVazia(texto));
    }

    @org.junit.Test
    public void testContaQuantidadeDeVogaisCom3Vogais() {
        String texto = "Helou";
        Assert.assertEquals(3, meuStringUtil.contaQuantidadeDeVogais(texto));
    }
    
    @org.junit.Test
    public void testContaQuantidadeDeVogaisSemVogais() {
        String texto = "KKKK";
        Assert.assertEquals(0, meuStringUtil.contaQuantidadeDeVogais(texto));
    }

    @org.junit.Test
    public void testInverterTexto() {
        Assert.assertEquals("atatab", meuStringUtil.inverterTexto("batata"));
    }
    
    @org.junit.Test
    public void testVerificaPalindromoComPalindromo() {
        Assert.assertTrue(meuStringUtil.verificaPalindromo("arara"));
    }
    
    @org.junit.Test
    public void testVerificaPalindromoSemPalindromo() {
        Assert.assertFalse(meuStringUtil.verificaPalindromo("Hello World"));
    }
    
}
