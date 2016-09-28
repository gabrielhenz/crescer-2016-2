public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    
    public Elfo(String n) {
        //Alterar o código para que todo Elfo 
        //criado SEEEEEM INFORMAR quantidade flechas
        //ganhe 42 flechas (valor default).
        
        //EU QUERO INFORMAR.
       this(n, 42);
    }
    
    public Elfo(String n, int flechas){
        nome = n;
        arco = new Item("Arco", 1);
        if(flechas >= 0)
        flecha = new Item("Flechas", flechas);
        else
        flecha = new Item("Flechas", 0);
   }
    
    public void setNome(String n) {
        nome = n;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Item getArco() {
        return arco;
    }
    
    public Item getFlecha(){
        return flecha;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public void atirarFlecha(){
        if((flecha.getQuantidade()-1)>0){
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
        }
    }
    
    public void atirarFlecha(int flechas) {
        if(flechas <= flecha.getQuantidade()){
            flecha.setQuantidade(flecha.getQuantidade() - flechas);
            experiencia+= flechas;
        }
        
    }
}









