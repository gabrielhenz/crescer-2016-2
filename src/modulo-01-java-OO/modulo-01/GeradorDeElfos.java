import java.util.*;
public final class GeradorDeElfos
{
    public static List<Elfo> retorna3ElfosVerdesE3ElfosNoturnosDesordenadosComVerdeNoInicio(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoVerde("verde1"),
                    new ElfoNoturno("noturno1"),
                    new ElfoNoturno("noturno2"),
                    new ElfoVerde("verde2"),
                    new ElfoNoturno("noturno3"),
                    new ElfoVerde("verde3")
                )
             );
    }
    
    public static List<Elfo> retorna3ElfosVerdesE3ElfosNoturnosDesordenadosComNoturnoNoInicio(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoNoturno("noturno1"),
                    new ElfoNoturno("noturno2"),
                    new ElfoVerde("verde1"),
                    new ElfoVerde("verde2"),
                    new ElfoNoturno("noturno3"),
                    new ElfoVerde("verde3")
                )
             );
    }
    
    public static List<Elfo> retorna3ElfosVerdesE3ElfosNoturnosOrdenados(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoVerde("verde1"),
                    new ElfoVerde("verde2"),
                    new ElfoVerde("verde3"),
                    new ElfoNoturno("noturno1"),
                    new ElfoNoturno("noturno2"),
                    new ElfoNoturno("noturno3")
                )
             );
    }
    
    public static List<Elfo> retorna3ElfosVerdes3ElfosNoturnosE3ElfosNormaisOrdenados(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoVerde("verde1"),
                    new ElfoVerde("verde2"),
                    new ElfoVerde("verde3"),
                    new ElfoNoturno("noturno1"),
                    new ElfoNoturno("noturno2"),
                    new ElfoNoturno("noturno3"),
                    new Elfo("normal1"),
                    new Elfo("normal2"),
                    new Elfo("normal3")
                )
             );
    }
    
    public static List<Elfo> retorna3ElfosVerdes(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoVerde("verde1"),
                    new ElfoVerde("verde2"),
                    new ElfoVerde("verde3")
                )
             );
    }
    
    public static List<Elfo> retorna3ElfosNoturnos(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoNoturno("noturno1"),
                    new ElfoNoturno("noturno2"),
                    new ElfoNoturno("noturno3")
                )
             );
    }
    
    public static List<Elfo> retorna3ElfosVerdesE3ElfosNoturnosIntercaladosComVerdeNoInicio(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoVerde("verde1"),
                    new ElfoNoturno("noturno1"),
                    new ElfoVerde("verde2"),
                    new ElfoNoturno("noturno2"),
                    new ElfoVerde("verde3"),
                    new ElfoNoturno("noturno3")
                )
             );
    }
    
    public static List<Elfo> retorna3ElfosVerdesE3ElfosNoturnosIntercaladosComNoturnoNoInicio(){
        return 
            new ArrayList<Elfo>(
                Arrays.asList(
                    new ElfoNoturno("noturno1"),
                    new ElfoVerde("verde1"),
                    new ElfoNoturno("noturno2"),
                    new ElfoVerde("verde2"),
                    new ElfoNoturno("noturno3"),
                    new ElfoVerde("verde3")
                )
             );
    }
}
