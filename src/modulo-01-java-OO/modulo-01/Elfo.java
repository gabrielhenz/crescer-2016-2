public class Elfo {
    private String nome;
    private int experiencia;
    private Status status;
    private Inventario inventario;
    
    public Elfo(String n) {
       this(n, 42);
    }
    
    public Elfo(String n, int flechas){
        nome = n;
        inventario = new Inventario();
        this.adicionarItem(new Item("Arco", 1));
        this.adicionarItem(new Item("Flechas", flechas >= 0 ? flechas : 42));
        status = Status.VIVO;
   }
    
    public void setNome(String n) {
        nome = n;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public Inventario getInventario(){
        return inventario;
    }
    
    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }
    
    public void atirarFlecha(Dwarf dwarf){
        if((inventario.getItens().get(1).getQuantidade()-1) >= 0){
            inventario.getItens().get(1).setQuantidade(inventario.getItens().get(1).getQuantidade() - 1);
            experiencia++;
            dwarf.fuiAtingido();
        }
    }
    
    public String toString(){
        boolean flechaNoSingular = this.inventario.getItens().get(1).getQuantidade() == 1;
        boolean nivelNoSingular = this.experiencia == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.", 
        nome, 
        inventario.getItens().get(1).getQuantidade(),
        flechaNoSingular ? "flecha" : "flechas",
        experiencia,
        nivelNoSingular ? "nível" : "níveis");
        //return (nome + " possui " + flecha.getQuantidade() + " flechas e " + experiencia + " níveis de experiência.");
    }
}









