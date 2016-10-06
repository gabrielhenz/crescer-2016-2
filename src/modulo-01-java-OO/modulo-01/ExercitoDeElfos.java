import java.util.ArrayList;

public class ExercitoDeElfos 
{
    {
        elfosExercito = new ArrayList<Elfo>();
    }
    
    private ArrayList<Elfo> elfosExercito;
    
    public Elfo[] getElfosExercito(){
        return elfosExercito.toArray(new Elfo[elfosExercito.size()]);
    }
    
    public void alistarElfo(Elfo elfo){
        /*
         * String nomeClasse = elfo.getClass().getName();
         * if(nomeClasse.equals("ElfoVerde") || nomeClasse.equals("ElfoNoturno"))
         * 
         * if(elfo.getClass() == ElfoNoturno.class || elfo.getClass() == ElfoVerde.class)
         */
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            elfosExercito.add(elfo);
    }
    
    
    /**
     * Busca um elfo no contingente de acordo com seu nome
     * 
     * @param String nome Nome do elfo a ser procurado. Ex: "Legolas"
     * @return Elfo Objeto Elfo completo que foi encontrado. Caso não encontre, retorna nulo. Caso tenha conflito de nomes, retorna o primeiro.
     */
    public Elfo buscarPorNome(String nome){
        // Java 8: contingente.filter(elfo -> nome.equals(elfo.getNome()))[0];
        // C# 3: contingente.FirstOrDefault(elfo => elfo.Nome == nome);
        // ES 2015 / ES6: contingente.filter(elfo => nome == elfo.nome)[0];
        // JS 5: contingente.filter(function(elfo) { return elfo.nome == nome })[0];
        // Ruby: contingente.filter_by { |x| x.nome == nome }
        
        
        //Elfo resultado = null;
        for(Elfo elfo : elfosExercito){
            if(nome.equals(elfo.getNome()))
                return elfo;
                //resultado = elfo;
                //break;
        }
        return null;
        //return resultado;
    }
    
    public ArrayList<Elfo> buscarPorStatus(Status status){
        // C#: return contingente.Where(x => x.Status == status);
        ArrayList<Elfo> elfos = new ArrayList<Elfo>();
        for(Elfo elfo : elfosExercito){
            if(elfo.status.equals(status)){
                elfos.add(elfo);
            }
        }
        return elfos;
    }

   

    /*public void alistar(Elfo elfo) {

        //String nomeClasse = elfo.getClass().getName();
        //Class clazz = elfo.getClass();
        boolean podeAlistar = 
            //nomeClasse.equals("ElfoVerde") || nomeClasse.equals("ElfoNoturno");
            //clazz == ElfoVerde.class || clazz == ElfoNoturno.class;
            elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        
        if (podeAlistar) {
            contingente.add(elfo);
        }
    }*/
}
