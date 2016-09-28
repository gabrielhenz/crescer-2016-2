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
        flecha = new Item("Flechas", flechas);
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
        flecha.setQuantidade(flecha.getQuantidade() - 1);
        experiencia++;
    }
    
    public void atirarFlecha(int flechas) {
        flecha.setQuantidade(flecha.getQuantidade() - flechas);
        experiencia++;
    }
}









