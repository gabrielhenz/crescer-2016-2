public class Elfo extends Personagem {

    private static int contadorDeElfos;
    
    public Elfo(String n) {
       this(n, 42);
    }

    public Elfo(String nome, int quantidadeFlechas) {
        super(nome);
        this.inicializarInventario(quantidadeFlechas);
        Elfo.contadorDeElfos++;
    }
    
    // ~Elfo() { }
    // https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#finalize()
    protected void finalize() throws Throwable {
        super.finalize();
        Elfo.contadorDeElfos--;
    }
    
    public static int getContadorDeElfos() {
        return Elfo.contadorDeElfos;
    }

    public Item getArco() {
        return this.inventario.getItens().get(0);
    }

    public Item getFlecha() {
        return this.inventario.getItens().get(1);
    }
    
    public void atirarFlecha(Dwarf dwarf){
        atirarFlechas(dwarf, 1);
    }
    
    public void atirarFlechas(Dwarf dwarf, int fatorExperiencia){
        int quantidadeFlechas = getFlecha().getQuantidade();
        boolean temFlecha = quantidadeFlechas > 0;
        if (temFlecha) {
            getFlecha().setQuantidade(quantidadeFlechas - 1);
            experiencia += 1 * fatorExperiencia;
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
    
    @Override
    protected void inicializarInventario(int quantidadeFlechas) {
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }
    
    @Override 
    public boolean equals(Object obj){ 
        Elfo elfo = (Elfo)obj; 
        return 
            this.nome.equals(elfo.nome) && 
            this.inventario.equals(elfo.inventario) &&
            this.experiencia == elfo.experiencia &&
            this.vida == elfo.vida &&
            this.status.equals(elfo.status);
    } 
}









