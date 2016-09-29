public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    private int experiencia;
    private Status status;
    
    public Elfo(String n) {
       this(n, 42);
    }
    
    public Elfo(String n, int flechas){
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", flechas >= 0 ? flechas : 42);
        status = Status.VIVO;
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
    
    public Status getStatus(){
        return status;
    }
    
    public void atirarFlecha(Dwarf dwarf){
        if((flecha.getQuantidade()-1) >= 0){
            flecha.setQuantidade(flecha.getQuantidade() - 1);
            experiencia++;
            dwarf.fuiAtingido();
        }
    }
    
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









