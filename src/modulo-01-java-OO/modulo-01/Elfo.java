public class Elfo extends Personagem {
    {
        vida = 100;
    }
    public Elfo(String n) {
       this(n, 42);
    }

    public Elfo(String nome, int quantidadeFlechas) {
        super(nome);
        this.adicionarItens(quantidadeFlechas);
    }
    
    public void adicionarItens(int quantidadeFlechas){
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }
    
    public Item getArco() {
        return this.inventario.getItens().get(0);
    }

    public Item getFlecha() {
        return this.inventario.getItens().get(1);
    }

    public void atirarFlecha(Dwarf dwarf) {
        int quantidadeFlechas = getFlecha().getQuantidade();
        boolean temFlecha = quantidadeFlechas > 0;
        if (temFlecha) {
            getFlecha().setQuantidade(quantidadeFlechas - 1);
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









