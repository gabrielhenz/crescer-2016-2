package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author gabriel.henz
 */
public class ExercicioDataCalendar {
    public static void main(String[]args) throws Exception{
        System.out.println(dataAtualDiaMesAno());
        System.out.println(dataAtualDiaMesAnoHoraMinSeg());
        
        System.out.println("Digite a data de nascimento no formato dd/mm/aaaa");
        String data = new Scanner(System.in).nextLine();
        System.out.format("Dia da semana: %s", diaDaSemana(data));
        
    }
    
    static String dataAtualDiaMesAno(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(new Date());
    }
    
    static String dataAtualDiaMesAnoHoraMinSeg(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return simpleDateFormat.format(new Date());
    }
    
    static String diaDaSemana(String dataTexto) throws Exception{
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = newDateFormat.parse(dataTexto);
        newDateFormat.applyPattern("EEEE");
        return newDateFormat.format(data);
    }
}
