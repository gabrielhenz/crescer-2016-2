/*
Deve receber o valor, a taxa de juros, o nº de parcelas(messes) 
e a data do 1º vencimento e retornar os valores e datas das parcelas. 
Ex. valor: 1000 juros: 10%, parcelas: 10 data: 30/06/2016
30/06/2016 - R$ 110,00
31/07/2016 - R$ 110,00
30/08/2016 - R$ 110,00 ...
 */
package br.com.cwi.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Parcelator {
    
    public static void main(String[]args){
        Scanner t = new Scanner(System.in);
        
        System.out.println("CALCULADOR DE PARCELAS E JUROS\n");
        
        System.out.print("Digite um valor: ");
        double valor = t.nextDouble();
        
        System.out.print("\nDigite os juros em porcentagem (%): ");
        int juros = t.nextInt();
        
        System.out.print("\nDigite a quantidade de parcelas: ");
        int parcelas = t.nextInt();
        
        System.out.print("\nDigite a data do primeiro vencimento no formato (dd/mm/aaaa): ");
        String dataTexto = t.next();
        
        new Parcelator().mostrarParcelasEData(valor, juros, parcelas, conversaoStringParaData(dataTexto));
    }
    
    public void mostrarParcelasEData(double valor, int juros, int parcelas, Date dataVencimento){
        int valorParcelas = calcularValorParcela(valor, juros, parcelas);
        String[] datasParcelas = pegarDatasParcelas(dataVencimento, parcelas);
        Arrays.asList(datasParcelas).forEach(d -> 
        { 
            System.out.format("\n%s - %d", d, valorParcelas); 
        });
    }
    
    public int calcularValorParcela(double valor, int juros, int parcelas){
        return (int)((valor/parcelas) + (((valor / parcelas) * juros) / 100));
    }
    
    public String[] pegarDatasParcelas(Date dataVencimento, int parcelas){
        String[] datasParcelas = new String[parcelas];
        Calendar c = Calendar.getInstance();
        c.setTime(dataVencimento);
        SimpleDateFormat frmt = new SimpleDateFormat("dd/MM/yyyy");
        datasParcelas[0] = frmt.format(dataVencimento);
        for(int i = 1; i < parcelas; i++){
            c.add(Calendar.MONTH, 1);
            datasParcelas[i] = frmt.format(c.getTime());
        }
        return datasParcelas;
    }
    
    static Date conversaoStringParaData(String dataTexto){
        Date data = null;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
        } catch (ParseException ex) {
            Logger.getLogger(MeuCalendarioUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
