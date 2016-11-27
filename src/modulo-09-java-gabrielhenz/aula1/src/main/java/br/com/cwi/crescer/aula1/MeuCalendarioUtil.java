/*
Criar uma classe MeuCalendarioUtil que tenha as definições abaixo.

Deve possuir um metodo que recebe a data de nascimento e retorne o dia da semana que a pessoa nasceu. 
(Segunda, Terça ...)
Deve possuir um metodo que recebe uma data e informe o tempo decorrido até a data atual. 30 ano(s), 
3 messe(s) e 12 dia(s)
Criar um metodo main, que informe os recursos disponíveis ao usuário.
*/

package br.com.cwi.crescer.aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class MeuCalendarioUtil {
    
    static Scanner t = new Scanner(System.in);
    
    public static void main(String[]args){
        boolean sair = false;
        while(!sair){
            System.out.println("\n\n-----MENU DE OPÇÕES-----"
                + "\n\n1 - Retorna o dia da semana do nascimento."
                + "\n2 - Diferença de datas em anos, meses e dias."
                + "\n3 - Sair.");
        System.out.print("\nDigite o número da sua opção: ");
        int opcao = t.nextInt();
        while(opcao < 1 || opcao > 3){
            System.out.print("\n\nOpção inválida.\nTente novamente: ");
            opcao = t.nextInt();
        }
        sair = escolherOpcao(opcao);
        }
    }
    
    static boolean escolherOpcao(int opcao){
        MeuCalendarioUtil self = new MeuCalendarioUtil();
        switch(opcao){
            case 1:
                System.out.print("Digite a sua data de aniversario no formato (dd/mm/aaaa): ");
                String dataNascimentoTexto = t.next();
                System.out.format("Dia da semana do nascimento: %s", 
                            self.diaDaSemanaDoNascimento(
                                    self.conversaoStringParaData(dataNascimentoTexto)
                            ));
                break;
            case 2:
                System.out.print("Digite uma data no formato (dd/mm/aaaa): ");
                String dataTexto = t.next();
                System.out.println(
                        self.diferencaDeDatas( 
                            self.conversaoStringParaData(dataTexto)
                        ));
                break;
            default:
                return true;
        }
        return false;
    }
    
    public String diaDaSemanaDoNascimento(Date dataNascimento){
       if(dataNascimento == null){
           return null;
       }
       return new SimpleDateFormat("EEEE").format(dataNascimento);
    } 
    
    public String diferencaDeDatas(Date data){
        if(data == null){
           return null;
        }
        long dataMili = data.getTime();
        long dataAtualMili = new Date().getTime();
        long diferenca;
        if (dataMili < dataAtualMili){
            diferenca = dataAtualMili - dataMili;
        } else {
            diferenca = dataMili - dataAtualMili;
        }
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(diferenca);
        int anos = c.get(Calendar.YEAR) - 1970;
        int meses = c.get(Calendar.MONTH);
        int dias = c.get(Calendar.DAY_OF_MONTH) - 1;
        return String.format("%d ano(s), %d mes(es), %d dia(s)", anos, meses, dias);
    }
    
    public Date conversaoStringParaData(String dataTexto){
        Date data = null;
        if(dataTexto.isEmpty()){
           return data;
       }
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
        } catch (ParseException ex) {
            Logger.getLogger(MeuCalendarioUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
