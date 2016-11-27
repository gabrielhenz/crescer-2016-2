/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula2;

import java.io.File;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class MeuFileUtilsTest {  
    @Test
    public void testSetInstrucaoDeAcaoInvalida(){
        assertNull(setEGetInstrucao("MK teste.txt"));
    }
    
    @Test
    public void testSetInstrucaoMk(){
        String instrucao = "mk teste.txt";
        assertEquals(instrucao, setEGetInstrucao(instrucao));
    }
    
    @Test
    public void testSetInstrucaoMkComMaisQue2Parametros(){
        assertNull(setEGetInstrucao("mk teste.txt teste2.txt"));
    }
    
    @Test
    public void testSetInstrucaoRmComMaisQue2Parametros(){
        assertNull(setEGetInstrucao("mk teste.txt teste2.txt"));
    }
    
    @Test
    public void testSetInstrucaoLsComMaisQue2Parametros(){
        assertNull(setEGetInstrucao("mk teste.txt teste2.txt"));
    }
    
    @Test
    public void testSetInstrucaoMvComMaisQue2Parametros(){
        String instrucao = "mv teste.txt teste2.txt";
        assertEquals(instrucao, setEGetInstrucao(instrucao));
    }
    
    @Test
    public void testSetInstrucaoRmSemArquivo(){
        assertNull(setEGetInstrucao("rm teste"));
    }
    
    @Test
    public void testSetInstrucaoMvSemSegundoArquivo(){
        assertNull(setEGetInstrucao("mv teste.txt teste2"));
    }
    
    @Test
    public void testSetInstrucaoMvSemPrimeiroArquivo(){
        assertNull(setEGetInstrucao("mv teste teste2.txt"));
    }

    
    private String setEGetInstrucao(String instrucao){
        MeuFileUtils meuFileUtils = new MeuFileUtils();
        meuFileUtils.setInstrucao(instrucao);
        return meuFileUtils.getInstrucao();
    }
}
