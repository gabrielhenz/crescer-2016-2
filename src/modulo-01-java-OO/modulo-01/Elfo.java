public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    
    public Elfo(String n) {
       this(n, 42);
    }
    
    public Elfo(String n, int flechas){
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", flechas >= 0 ? flechas : 42);
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
    
    
    public void atirarFlecha(Dwarf dwarf){
        if((flecha.getQuantidade()-1) >= 0){
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
            dwarf.fuiAtingido();
        }
    }
    
    /*public void atirarFlecha(Dwarf dwarf, int flechas){
        if(flechas > 0 && flecha.getQuantidade() > 0){
            if(flechas <= flecha.getQuantidade()){
                flecha.setQuantidade(flecha.getQuantidade() - flechas);
                experiencia+= flechas;
                dwarf.fuiAtingido(flechas);
            }else{
                flecha.setQuantidade(flecha.getQuantidade() - 42);
                experiencia+= 42;
                dwarf.fuiAtingido(42);
            }
        }
    }*/
    
    public String toString(){
        boolean flechaNoSingular = this.flecha.getQuantidade() == 1;
        boolean nivelNoSingular = this.experiencia == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.", 
        nome, 
        flecha.getQuantidade(),
        flechaNoSingular ? "flecha" : "flechas",
        experiencia,
        nivelNoSingular ? "nível" : "níveis");
        //return (nome + " possui " + flecha.getQuantidade() + " flechas e " + experiencia + " níveis de experiência.");
    }
}









