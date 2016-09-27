public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    
    public Elfo(String n) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 42);
    }
    
    public void setNome(String n) {
        nome = n;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void atirarFlecha() {
        flecha.setQuantidade(flecha.getQuantidade() - 1);
        experiencia++;
    }
    
    public Item getArco(){
        return arco;
    }
    
    /*
    public atirarFlechaRefactory(this.flechas, this.experiencia){
    if(boolean acertar == true){
        flecha.setQuantidade(flecha.getQuantidade()-1);
        experiencia++;
    }else{
        flecha.setQuantidade(flecha.getQuantidade()-1);
    }
    }*/
    
    /*public void atirarFlechaRefactory(){
        experiencia++;
        flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}









